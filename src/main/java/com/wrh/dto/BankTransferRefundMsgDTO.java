package com.wrh.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午6:18 on 2018/5/27.
 */
public class BankTransferRefundMsgDTO implements Serializable{

    private int bankTaskId;
    private int accountId;
    private BigDecimal money;

    public int getBankTaskId() {
        return bankTaskId;
    }

    public void setBankTaskId(int bankTaskId) {
        this.bankTaskId = bankTaskId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
