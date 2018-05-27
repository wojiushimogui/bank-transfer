package com.wrh.services.impl.check;

import com.wrh.dto.BankTransferTask;
import com.wrh.dto.ResponseDto;
import com.wrh.entity.BankAccount;
import com.wrh.enums.FailedEnum;
import com.wrh.services.BankAccountMangerService;
import com.wrh.services.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午3:47 on 2018/5/27.
 */
@Service
public class MoneyCheckServiceImpl implements CheckService {
    @Autowired
    private BankAccountMangerService bankAccountMangerService;
    @Override
    public ResponseDto check(BankTransferTask bankTransferTask) {

        BankAccount formBankAccount = bankAccountMangerService.getBankAccountById(bankTransferTask.getFromBankAccountId());
        if (formBankAccount == null) {
            return ResponseDto.fail(FailedEnum.BANKACCOUNT_ERROR,"银行卡号有误");
        }
        if (bankTransferTask.getMoney().compareTo(new BigDecimal(0)) < 1) {
            return ResponseDto.fail(FailedEnum.MONEY_ERROR,"转账金额必须大于0");
        }
        if (bankTransferTask.getMoney().compareTo(formBankAccount.getAccountMoney()) > 1) {
            return ResponseDto.fail(FailedEnum.INSUFFICIENT_BALANCE,"余额不足");
        }
        return ResponseDto.success(null);
    }
}
