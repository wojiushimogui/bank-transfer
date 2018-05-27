package com.wrh.services.impl;

import com.wrh.dto.ResponseDto;
import com.wrh.entity.BankAccount;
import com.wrh.services.BankAccountMangerService;
import com.wrh.services.BankTransferInneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午4:23 on 2018/5/27.
 */
@Service
public class BankTransferInneServiceImpl implements BankTransferInneService {

    @Autowired
    private BankAccountMangerService bankAccountMangerService;

    @Override
    public ResponseDto transfer(Integer bankAccountId, BigDecimal money) {
        BankAccount bankAccount = bankAccountMangerService.getBankAccountById(bankAccountId);
        bankAccount.setAccountMoney(bankAccount.getAccountMoney().subtract(money));
        //更新
        return bankAccountMangerService.updateBankAccount(bankAccount);
    }




}
