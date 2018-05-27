package com.wrh.services.impl;

import com.wrh.dto.BankTransferTask;
import com.wrh.dto.ResponseDto;
import com.wrh.enums.FailedEnum;
import com.wrh.services.*;
import com.wrh.utils.GenerateObjectUtil;
import com.wrh.utils.TransferStatus;
import com.wrh.utils.TransferTaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午2:54 on 2018/5/27.
 */
@Service
public class BankTransferServiceImpl implements BankTransferService {

    @Autowired
    List<CheckService> checkServiceList;
    @Autowired
    private BankTransferInneService bankTransferInneService;
    @Autowired
    private BankAccountTransferLogService bankAccountTransferLogService;

    @Autowired
    private BankTransferTaskService bankTransferTaskService;

    @Autowired
    private MsgService msgService;

    //
    @Override
    public ResponseDto transferMoney(BankTransferTask bankTransferTask) {
        //1、对任务进行有效性校验，例如：账户是否存在、转账金额是否有效。
        for (CheckService checkService : checkServiceList) {
             ResponseDto checkRes = checkService.check(bankTransferTask);
             if (checkRes.failed()) {
                 bankAccountTransferLogService.addTransferLog(GenerateObjectUtil.generateLog(bankTransferTask,TransferStatus.CHECK_FAIL.getCode(),checkRes.getMessage()));
                 return checkRes;
             }
        }
        //2、更改任务状态为running
        boolean modifyStatusRes = bankTransferTaskService.updateStatus(bankTransferTask.getId(),bankTransferTask.getStatus(), TransferTaskStatus.RUNNING.getCode());
        if (!modifyStatusRes) {
            bankAccountTransferLogService.addTransferLog(GenerateObjectUtil.generateLog(bankTransferTask,TransferStatus.MODIAF_INIT_TO_RUNNING_STATUS_FAIL.getCode(),TransferStatus.MODIAF_INIT_TO_RUNNING_STATUS_FAIL.getDesc()));
            return ResponseDto.fail(FailedEnum.BANKACCOUNT_ERROR,TransferStatus.MODIAF_INIT_TO_RUNNING_STATUS_FAIL.getDesc());
        }

        //3、处理转账业务：源账户扣除转账金额，目标账户增加转账金额
        ResponseDto responseDto = bankTransferInneService.transfer(bankTransferTask.getFromBankAccountId(), bankTransferTask.getMoney());
        if (responseDto.failed()) {
            bankAccountTransferLogService.addTransferLog(GenerateObjectUtil.generateLog(bankTransferTask,TransferStatus.MODIFA_FROM_BANKACCOUNT_FAIL.getCode(),TransferStatus.MODIFA_FROM_BANKACCOUNT_FAIL.getDesc()));
            return responseDto;
        }
        ResponseDto responseDto2 = bankTransferInneService.transfer(bankTransferTask.getToBankAccountId(), bankTransferTask.getMoney().multiply(new
                BigDecimal(-1)));

        if (responseDto2.failed()) {
            //退款,具体的退款逻辑交给 此 消息的监听者来完成。
            // 这里没有考虑重试机制。更好的处理方式是：重试N次，如果不成功，则退款。
            bankAccountTransferLogService.addTransferLog(GenerateObjectUtil.generateLog(bankTransferTask,TransferStatus.MODIFA_TO_BANKACCOUNT_FAIL.getCode(),TransferStatus.MODIFA_TO_BANKACCOUNT_FAIL.getDesc()));
            msgService.sendMsg(GenerateObjectUtil.generateBankTrandferRefundMsg(bankTransferTask));

        }

        //4、修改转账任务状态，并记录转账历史
        if (!bankTransferTaskService.updateStatus(bankTransferTask.getId(),bankTransferTask.getStatus(),TransferStatus.SUCCESS.getCode())) {
            bankAccountTransferLogService.addTransferLog(GenerateObjectUtil.generateLog(bankTransferTask,TransferStatus.MODIAF_RUNNING_TO_SUCCESS_STATUS_FAIL.getCode(),TransferStatus.MODIAF_RUNNING_TO_SUCCESS_STATUS_FAIL.getDesc()));
        }
        else {
            bankAccountTransferLogService.addTransferLog(GenerateObjectUtil.generateLog(bankTransferTask,TransferStatus.SUCCESS.getCode(),TransferStatus.SUCCESS.getDesc()));
        }


        return ResponseDto.success(null);

    }


}
