package com.wrh.services.impl;

import com.wrh.services.MsgService;
import org.springframework.stereotype.Service;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午6:18 on 2018/5/27.
 */
@Service
public class MsgServiceImpl implements MsgService {
    @Override
    public void sendMsg(String msg) {
        //发出退款消息，具体实现省略。
    }
}
