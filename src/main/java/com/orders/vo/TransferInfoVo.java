package com.orders.vo;

public class TransferInfoVo {
    public int tMoney;
    public String bankNo;
    public String bankName;
    public String bankPerson;

    public String phone;

    public int gettMoney() {
        return tMoney;
    }

    public void settMoney(int tMoney) {
        this.tMoney = tMoney;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankPerson() {
        return bankPerson;
    }

    public void setBankPerson(String bankPerson) {
        this.bankPerson = bankPerson;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
