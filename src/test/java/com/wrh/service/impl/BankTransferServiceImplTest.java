package com.wrh.service.impl;

import com.wrh.dto.BankTransferTask;
import com.wrh.service.AbstractTest;
import com.wrh.services.BankTransferService;
import com.wrh.utils.TransferTaskStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午6:34 on 2018/5/27.
 */
public class BankTransferServiceImplTest extends AbstractTest {


    @Autowired
    private BankTransferService bankTransferService;

    @Test
    public void test_transferMoney() {
        bankTransferService.transferMoney(genereateTask());
    }

    private BankTransferTask genereateTask() {
        BankTransferTask task = new BankTransferTask();
        task.setId(1);
        task.setFromBankAccountId(1001);
        task.setToBankAccountId(1002);
        task.setStatus(TransferTaskStatus.INIT.getCode());
        task.setMoney(new BigDecimal(10000));

        return task;
    }
}
