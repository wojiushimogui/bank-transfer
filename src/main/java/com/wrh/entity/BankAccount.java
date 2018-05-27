package com.wrh.entity;

import java.math.BigDecimal;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午2:45 on 2018/5/27.
 */
public class BankAccount {
    private int id;
    private BigDecimal accountMoney;
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public BankAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
    }
}
