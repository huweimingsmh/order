package com.orders.controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.dao.AccountWater;
import com.orders.dao.TransferWater;
import com.orders.service.AccountService;
import com.orders.service.account.AccountServiceImp;
import com.orders.utils.tools.ServiceTools;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.TransferCheckVo;
import com.orders.vo.TransferInfoVo;
import com.orders.vo.YaoqingRechangeVo;
import com.orders.vo.YongJiRechangeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private static Logger log = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/ainfo", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<AccountWater> getAccountWaterInfo(String phone) {
        return accountService.getAccountWater(phone);
    }

    @RequestMapping(value = "/ainfobytime", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<AccountWater> getAccountWaterInfoByTime(String phone, String starTime, String endTime) {
        return accountService.getAccountWater(starTime, endTime, phone);
    }

    @RequestMapping(value = "/ainfobystate", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<AccountWater> getAccountWaterInfoByState(String phone, int state) {
        return accountService.getAccountWater(phone, state);
    }

    @RequestMapping(value = "/tinfo", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<TransferWater> getTransferWaterInfo(String phone) {
        return accountService.getTransferWater(phone);
    }

    @RequestMapping(value = "/tadd", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addTransferWaterInfo(TransferInfoVo vo) {
        if (null != vo) {
            accountService.addTransferWater(vo);
        }
    }

    @RequestMapping(value = "/tverify", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void verifyTransfer(TransferCheckVo vo) {
        if (null != vo) {
            accountService.checkTransfer(vo);
        }
    }

    @RequestMapping(value = "/ryj", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String rechangeYongJin(String phone, int yongJin) {
        YongJiRechangeVo vo = accountService.toYongjiRechange(phone, yongJin);
        if (null != vo) {

            try {
                ServiceTools.toJson(vo);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return ToolsUtils.forwordPage("url", "error.html");
    }

    @RequestMapping(value = "/ryq", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String rechangeYaoQing(String phone, int yaoQing) {

        YaoqingRechangeVo vo = accountService.fromYaoqingRechange(phone);
        if (null != vo) {

            try {
                ServiceTools.toJson(vo);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return ToolsUtils.forwordPage("url", "error.html");
    }

}
