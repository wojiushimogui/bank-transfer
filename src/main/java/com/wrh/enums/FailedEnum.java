package com.wrh.enums;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午3:20 on 2018/5/27.
 */

public enum  FailedEnum {

    BANKACCOUNT_ERROR(1,"银行账号有错误"),
    MONEY_ERROR(2,"转账金额有误"),
    INSUFFICIENT_BALANCE(3,"余额不足"),
    UPDATE_ERROR(4,"更新错误"),
    BANKTASK_INVALID(5,"转账任务无效");

    private int code;
    private String desc;

    FailedEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
