package com.orders.vo.task;

import java.util.List;

public class PingJiaVo {

    private String puTong;
    private List<String> word;
    private List<ImgHaoPingVo> imgs;
    private List<VodeHaoPingVo> vodes;

    public String getPuTong() {
        return puTong;
    }

    public void setPuTong(String puTong) {
        this.puTong = puTong;
    }

    public List<String> getWord() {
        return word;
    }

    public void setWord(List<String> word) {
        this.word = word;
    }

    public List<ImgHaoPingVo> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgHaoPingVo> imgs) {
        this.imgs = imgs;
    }

    public List<VodeHaoPingVo> getVodes() {
        return vodes;
    }

    public void setVodes(List<VodeHaoPingVo> vodes) {
        this.vodes = vodes;
    }
}
