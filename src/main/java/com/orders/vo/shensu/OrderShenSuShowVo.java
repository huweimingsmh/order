package com.orders.vo.shensu;

import java.util.List;

public class OrderShenSuShowVo {
    private String shenSuer;
    private String title;
    private String context;
    private List<String> imgs;
    private String chuLi;
    private String chuLiJieGuo;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getShenSuer() {
        return shenSuer;
    }

    public void setShenSuer(String shenSuer) {
        this.shenSuer = shenSuer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public String getChuLi() {
        return chuLi;
    }

    public void setChuLi(String chuLi) {
        this.chuLi = chuLi;
    }

    public String getChuLiJieGuo() {
        return chuLiJieGuo;
    }

    public void setChuLiJieGuo(String chuLiJieGuo) {
        this.chuLiJieGuo = chuLiJieGuo;
    }
}
