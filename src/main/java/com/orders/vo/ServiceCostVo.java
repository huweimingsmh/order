package com.orders.vo;

import java.util.List;
import java.util.Map;

public class ServiceCostVo {
        List<BaseServiceCost> baseCost;
        Map<String,String> otherCost;

    public List<BaseServiceCost> getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(List<BaseServiceCost> baseCost) {
        this.baseCost = baseCost;
    }

    public Map<String, String> getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(Map<String, String> otherCost) {
        this.otherCost = otherCost;
    }
}
