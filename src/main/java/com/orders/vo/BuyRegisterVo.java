package com.orders.vo;

public class BuyRegisterVo extends RegisterVo{

    private String weixin;
    private String taobaovip;

    private byte sex;

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
