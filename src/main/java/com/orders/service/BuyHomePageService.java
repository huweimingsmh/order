package com.orders.service;

import com.orders.vo.BuyHomeVo;
import com.orders.vo.HomeVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BuyHomePageService {

    public BuyHomeVo getHomePageDate(String phone, HttpSession session);
}
