package com.wrh.services;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午5:23 on 2018/5/27.
 */
public interface BankTransferTaskService {
    boolean updateStatus(int id,int originStatus,int newStatus);
}
