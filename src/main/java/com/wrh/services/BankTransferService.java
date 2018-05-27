package com.wrh.services;

import com.wrh.dto.BankTransferTask;
import com.wrh.dto.ResponseDto;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午2:54 on 2018/5/27.
 */
public interface BankTransferService {

    //函数功能：对转账任务进行处理
    ResponseDto transferMoney(BankTransferTask bankTransferTask);
}
