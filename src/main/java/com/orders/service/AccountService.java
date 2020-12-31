package com.orders.service;

import com.orders.dao.AccountWater;
import com.orders.dao.TransferWater;
import com.orders.vo.TransferCheckVo;
import com.orders.vo.TransferInfoVo;
import com.orders.vo.YaoqingRechangeVo;
import com.orders.vo.YongJiRechangeVo;

import java.util.List;

public interface AccountService {

    public List<AccountWater> getAccountWater(String phone);

    public List<AccountWater> getAccountWater(String starTime,String endTime,String phone);

    public void addAccountWater(AccountWater water);

    public List<AccountWater> getAccountWater(String phone,int category);

    public List<TransferWater> getTransferWater(String phone);

    public void addTransferWater(TransferInfoVo vo);

    public void checkTransfer(TransferCheckVo vo);

    public YaoqingRechangeVo fromYaoqingRechange(String phone);

    public YongJiRechangeVo toYongjiRechange(String phone, int money);
}
