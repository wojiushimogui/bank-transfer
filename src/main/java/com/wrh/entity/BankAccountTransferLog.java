package com.wrh.entity;

import java.math.BigDecimal;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午5:04 on 2018/5/27.
 */

public class BankAccountTransferLog {

    private int id;
    private int bankTransferTaskId;
    private int bankTransferTaskStatus;
    private int fromBankAccountId;
    private int toBankAccountId;
    private BigDecimal money;
    private int status;
    private String descri;

    public int getBankTransferTaskStatus() {
        return bankTransferTaskStatus;
    }

    public void setBankTransferTaskStatus(int bankTransferTaskStatus) {
        this.bankTransferTaskStatus = bankTransferTaskStatus;
    }

    public int getBankTransferTaskId() {
        return bankTransferTaskId;
    }

    public void setBankTransferTaskId(int bankTransferTaskId) {
        this.bankTransferTaskId = bankTransferTaskId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public BankAccountTransferLog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromBankAccountId() {
        return fromBankAccountId;
    }

    public void setFromBankAccountId(int fromBankAccountId) {
        this.fromBankAccountId = fromBankAccountId;
    }

    public int getToBankAccountId() {
        return toBankAccountId;
    }

    public void setToBankAccountId(int toBankAccountId) {
        this.toBankAccountId = toBankAccountId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
