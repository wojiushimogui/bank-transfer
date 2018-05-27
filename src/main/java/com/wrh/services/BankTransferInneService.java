package com.wrh.services;

import com.wrh.dto.ResponseDto;

import java.math.BigDecimal;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午4:23 on 2018/5/27.
 */
public interface BankTransferInneService {

    public ResponseDto transfer(Integer bankAccountId, BigDecimal money);
}
