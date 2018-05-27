package com.wrh.services.impl.check;

import com.wrh.dto.BankTransferTask;
import com.wrh.dto.ResponseDto;
import com.wrh.enums.FailedEnum;
import com.wrh.services.CheckService;
import com.wrh.utils.TransferTaskStatus;
import org.springframework.stereotype.Service;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午5:27 on 2018/5/27.
 */
@Service
public class BankTransferTaskStatusCheckServiceImpl implements CheckService {

    @Override
    public ResponseDto check(BankTransferTask bankTransferTask) {

        if (bankTransferTask == null || bankTransferTask.getStatus() != TransferTaskStatus.INIT.getCode()) {
            return ResponseDto.fail(FailedEnum.BANKTASK_INVALID,"转账任务无效");
        }
        return ResponseDto.success(null);

    }
}
