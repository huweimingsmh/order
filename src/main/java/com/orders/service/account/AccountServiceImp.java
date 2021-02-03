package com.orders.service.account;

import com.orders.dao.AccountWater;
import com.orders.dao.TransferWater;
import com.orders.dao.shangjia.ShangJia;
import com.orders.mapper.AccoutWaterMapper;
import com.orders.mapper.ShangJiaMapper;
import com.orders.mapper.TransferWaterMapper;
import com.orders.service.AccountService;
import com.orders.service.maishou.BuyServiceImp;
import com.orders.utils.statecode.AccountCategory;
import com.orders.utils.tools.ServiceTools;
import com.orders.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value="accountService")
public class AccountServiceImp implements AccountService {
    private static Logger log= LoggerFactory.getLogger(AccountServiceImp.class);

    @Mapper
    AccoutWaterMapper accountMapper;
    @Mapper
    TransferWaterMapper transferMapper;
    @Mapper
    ShangJiaMapper shangJiaMapper;

    @Override
    public List<AccountWater> getAccountWater(String phone) {
        try {
            return accountMapper.getAccountWater(phone);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public TransferWater getTransferWater(long id) {
        try{
        return transferMapper.getTransferWaterById(id);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<AccountWater> getAccountWater(String starTime, String endTime, String phone) {
        try {
            return accountMapper.getAccountWaterByTime(starTime, endTime, phone);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void addAccountWater(AccountWater water) {

    }


    @Override
    public List<AccountWater> getAccountWater(String phone, int category) {
        try{
        return accountMapper.getAccountWaterByCategory(phone, category);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<TransferWater> getTransferWater(String phone) {
        try{
        return transferMapper.getTransferWater(phone);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void addTransferWater(TransferInfoVo vo) {
        TransferWater water = new TransferWater();
        water.setaDes("");
        water.setBankName(vo.getBankName());
        water.setBankNo(vo.getBankNo());
        water.setBankPerson(vo.getBankPerson());
        water.setsTime(new Date());
       water.setcTime(new Date());

        water.setState(0);
        water.setwMoney(vo.gettMoney());

        try {
            transferMapper.addTransferWater(water);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public YaoqingRechangeVo fromYaoqingRechange(String phone) {
        try {
            ShangJia sj = shangJiaMapper.getShangJia(phone);
            if (null != sj) {
                if (sj.getYaoqingMoney() > 0) {
                    shangJiaAccountHelp(phone, AccountCategory.I_RECHARGE, sj.getYaoqingMoney());
                    AccountWater aw = ServiceTools.createAccountWater(phone, sj.getYaoqingMoney(), (sj.getSelfMoney() + sj.getYaoqingMoney()), AccountCategory.I_RECHARGE);
                    accountMapper.addAccountWater(aw);
                    YaoqingRechangeVo vo = new YaoqingRechangeVo((sj.getSelfMoney() + sj.getYaoqingMoney()), 0);
                    return vo;
                }
            }
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    public YongJiRechangeVo toYongjiRechange(String phone, int money) {
        try{
        ShangJia sj = shangJiaMapper.getShangJia(phone);
        if(null!=sj){
            if(sj.getSelfMoney()>0 && money>0){
                shangJiaAccountHelp(phone,AccountCategory.I_RECHARGE,money);
                AccountWater aw=ServiceTools.createAccountWater(phone,money,(sj.getSelfMoney()-money),AccountCategory.Y_RECHARGE);
                accountMapper.addAccountWater(aw);
                YongJiRechangeVo vo=new YongJiRechangeVo((sj.getSelfMoney()-money),money);
                return vo;
            }
        }
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void checkTransfer(TransferCheckVo vo) {
        TransferWater water = getTransferWater(vo.getId());
        try{
        if (null != water) {
            TransferChangeVo tc = new TransferChangeVo();
            tc.setId(water.getId());
            tc.setConfirmTime(new Date());
            tc.setDesc(vo.getDesc());
            tc.setState(vo.getState());
            transferMapper.updateTransferState(tc);
            ShangJia sj = shangJiaMapper.getShangJia(water.getPhone());
            if (null != sj) {
                shangJiaAccountHelp(sj.getPhone(), AccountCategory.S_RECHARGE, water.getwMoney());
            }
            AccountWater aw = ServiceTools.createAccountWater(water.getPhone(), water.getwMoney(), sj.getSelfMoney(), AccountCategory.S_RECHARGE);
            accountMapper.addAccountWater(aw);
        }
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    private void shangJiaAccountHelp(String phone, int category, double money) {
        try{
        switch (category) {
            case AccountCategory.I_RECHARGE:
                shangJiaMapper.updateYaoQingMoney(phone, money);
                break;
            case AccountCategory.S_RECHARGE:
                shangJiaMapper.updateSelfMoney(phone, money);
                break;
            case AccountCategory.Y_RECHARGE:
                shangJiaMapper.updateYongJinMoney(phone, money);
                break;
        }
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
