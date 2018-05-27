package com.wrh.services;

import com.wrh.dto.ResponseDto;
import com.wrh.entity.BankAccount;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午2:52 on 2018/5/27.
 */
public interface BankAccountMangerService {

    BankAccount getBankAccountById(Integer id);

    ResponseDto updateBankAccount(BankAccount bankAccount);
}
