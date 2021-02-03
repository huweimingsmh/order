package com.orders.vo.task;

import java.util.List;

public class TimeTaskVo {
    private String date;
    private String  fromHour;
    private String toHour;
    private int count;
    private int fangShi;
    private List<MeiGeVo> meiGe;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFangShi() {
        return fangShi;
    }

    public void setFangShi(int fangShi) {
        this.fangShi = fangShi;
    }

    public List<MeiGeVo> getMeiGe() {
        return meiGe;
    }

    public void setMeiGe(List<MeiGeVo> meiGe) {
        this.meiGe = meiGe;
    }
}
