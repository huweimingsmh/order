package com.orders.vo.task;

import java.util.List;

public class SouSuoVo {
    private int way;
    private String words;
    private int orderCount;
    private List<Integer> attach;
    private int doing;

    public int getDoing() {
        return doing;
    }

    public void setDoing(int doing) {
        this.doing = doing;
    }

    public int getWay() {
        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public List<Integer> getAttach() {
        return attach;
    }

    public void setAttach(List<Integer> attach) {
        this.attach = attach;
    }
}
