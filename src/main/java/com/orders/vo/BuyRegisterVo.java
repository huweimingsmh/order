package com.orders.vo;

public class BuyRegisterVo {
    private String phone;
    private String checkCode;
    private String pwd;
    private String weixin;
    private String taobaovip;

    private byte sex;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getTaobaovip() {
        return taobaovip;
    }

    public void setTaobaovip(String taobaovip) {
        this.taobaovip = taobaovip;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }
}
