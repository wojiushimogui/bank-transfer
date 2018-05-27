package com.wrh.utils;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午5:12 on 2018/5/27.
 */
public enum TransferStatus {
    CHECK_FAIL(1,"校验失败"),
    MODIAF_INIT_TO_RUNNING_STATUS_FAIL(2,"修改任务状态(init-->running)失败"),
    MODIAF_RUNNING_TO_SUCCESS_STATUS_FAIL(3,"修改任务状态(running-->success)失败"),
    MODIAF_RUNNING_TO_FAIl_STATUS_FAIL(4,"修改任务状态(running-->fail)失败"),
    MODIFA_FROM_BANKACCOUNT_FAIL(5,"源账户扣除转账金额失败"),
    MODIFA_TO_BANKACCOUNT_FAIL(5,"目标账户增加转账金额失败"),
    SUCCESS(5,"转账成功");


    private int code;
    private String desc;

    TransferStatus(int code, String desc) {
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
