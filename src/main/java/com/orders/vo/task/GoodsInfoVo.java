package com.orders.vo.task;

public class GoodsInfoVo {
    private String goodsLink;
    private String goodsName;
    private String shop;
    private String image;
    private int sku;
    private int everyBuy;
    private int everyCost;
    private String skuDes;

    public String getGoodsLink() {
        return goodsLink;
    }

    public void setGoodsLink(String goodsLink) {
        this.goodsLink = goodsLink;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getEveryBuy() {
        return everyBuy;
    }

    public void setEveryBuy(int everyBuy) {
        this.everyBuy = everyBuy;
    }

    public int getEveryCost() {
        return everyCost;
    }

    public void setEveryCost(int everyCost) {
        this.everyCost = everyCost;
    }

    public String getSkuDes() {
        return skuDes;
    }

    public void setSkuDes(String skuDes) {
        this.skuDes = skuDes;
    }
}
