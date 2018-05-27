package com.wrh.utils;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午5:58 on 2018/5/27.
 */
public enum TransferTaskStatus {
    INIT(1,"初始状态"),
    RUNNING(2,"转账中"),
    SUCCESS(3,"转账成功"),
    FAIL(4,"转账失败");


    private int code;
    private String desc;

    TransferTaskStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
