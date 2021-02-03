package com.orders.vo.task;

import java.util.List;

public class ZengZhiServiceVo {
    private int sex;
    private String age;
    private List<Integer> jieDanType;
    private int huaBei;
    private int weekPoint;
    private int drill;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Integer> getJieDanType() {
        return jieDanType;
    }

    public void setJieDanType(List<Integer> jieDanType) {
        this.jieDanType = jieDanType;
    }

    public int getHuaBei() {
        return huaBei;
    }

    public void setHuaBei(int huaBei) {
        this.huaBei = huaBei;
    }

    public int getWeekPoint() {
        return weekPoint;
    }

    public void setWeekPoint(int weekPoint) {
        this.weekPoint = weekPoint;
    }

    public int getDrill() {
        return drill;
    }

    public void setDrill(int drill) {
        this.drill = drill;
    }
}
