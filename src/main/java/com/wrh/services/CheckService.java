package com.wrh.services;

import com.wrh.dto.BankTransferTask;
import com.wrh.dto.ResponseDto;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午2:59 on 2018/5/27.
 */
public interface CheckService {

    ResponseDto check(BankTransferTask bankTransferTask);
}
