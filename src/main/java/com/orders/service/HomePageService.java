package com.orders.service;

import com.orders.vo.HomeVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface HomePageService {

    public HomeVo getHomePageDate(String phone, HttpSession session);
}
