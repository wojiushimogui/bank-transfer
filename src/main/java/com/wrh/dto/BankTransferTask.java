package com.wrh.dto;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午3:04 on 2018/5/27.
 */
@NoArgsConstructor
public class BankTransferTask implements Serializable{
    private int id;
    private Integer fromBankAccountId;
    private Integer toBankAccountId;
    private BigDecimal money;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFromBankAccountId() {
        return fromBankAccountId;
    }

    public void setFromBankAccountId(Integer fromBankAccountId) {
        this.fromBankAccountId = fromBankAccountId;
    }

    public Integer getToBankAccountId() {
        return toBankAccountId;
    }

    public void setToBankAccountId(Integer toBankAccountId) {
        this.toBankAccountId = toBankAccountId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
