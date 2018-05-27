package com.wrh.utils;

import com.alibaba.fastjson.JSON;
import com.wrh.dto.BankTransferRefundMsgDTO;
import com.wrh.dto.BankTransferTask;
import com.wrh.entity.BankAccountTransferLog;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午6:25 on 2018/5/27.
 */
public class GenerateObjectUtil {

    public static BankAccountTransferLog generateLog(BankTransferTask bankTransferTask, int status, String desc) {
        BankAccountTransferLog log = new BankAccountTransferLog();
        log.setBankTransferTaskId(bankTransferTask.getId());
        log.setBankTransferTaskStatus(bankTransferTask.getStatus());
        log.setFromBankAccountId(bankTransferTask.getFromBankAccountId());
        log.setToBankAccountId(bankTransferTask.getToBankAccountId());
        log.setMoney(bankTransferTask.getMoney());
        log.setStatus(status);
        log.setDescri(desc);
        return log;
    }

    public static String generateBankTrandferRefundMsg(BankTransferTask transferTask) {
        BankTransferRefundMsgDTO msg = new BankTransferRefundMsgDTO();
        msg.setBankTaskId(transferTask.getId());
        msg.setAccountId(transferTask.getFromBankAccountId());
        msg.setMoney(transferTask.getMoney());
        return JSON.toJSONString(msg);
    }
}
