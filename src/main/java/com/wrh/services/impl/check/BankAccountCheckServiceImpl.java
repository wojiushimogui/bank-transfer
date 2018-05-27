package com.wrh.services.impl.check;

import com.wrh.dto.BankTransferTask;
import com.wrh.dto.ResponseDto;
import com.wrh.entity.BankAccount;
import com.wrh.enums.FailedEnum;
import com.wrh.services.BankAccountMangerService;
import com.wrh.services.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午3:00 on 2018/5/27.
 */
@Service
public class BankAccountCheckServiceImpl implements CheckService {
    @Autowired
    private BankAccountMangerService bankAccountMangerService;
    @Override
    public ResponseDto check(BankTransferTask bankTransferTask) {

        BankAccount formBankAccount = bankAccountMangerService.getBankAccountById(bankTransferTask.getFromBankAccountId());
        if (formBankAccount == null
                || bankAccountMangerService.getBankAccountById(bankTransferTask.getToBankAccountId()) == null) {
            return ResponseDto.fail(FailedEnum.BANKACCOUNT_ERROR,"银行卡号有误");
        }
        return ResponseDto.success(null);
    }
}
