package com.wrh.services.impl;

import com.wrh.services.BankTransferTaskService;
import org.springframework.stereotype.Service;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午5:24 on 2018/5/27.
 */
@Service
public class BankTransferTaskServiceImpl implements BankTransferTaskService {

    @Override
    public boolean updateStatus(int id, int originStatus,int newStatus) {
        //update BankTransferTask set status = #{status} where id = #{id} and status = #{originStatus};
        return true;
    }
}
