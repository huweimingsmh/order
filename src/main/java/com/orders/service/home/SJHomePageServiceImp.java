package com.orders.service.home;

import com.orders.dao.shangjia.ShangJia;
import com.orders.service.*;
import com.orders.vo.HomeVo;
import com.orders.vo.NoticVo;
import com.orders.vo.order.OrderStateCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service(value="homePageService")
public class SJHomePageServiceImp implements HomePageService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private MessageService mesageService;
    @Autowired
    private ShenSuService shenSuService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ShangJiaService sjService;
    @Override
    public HomeVo getHomePageDate(String phone, HttpSession session) {
        OrderStateCountVo stateCountVo=orderService.getOrderRefundCount(phone);
//        int refund=orderService.getOrderRefundCount(phone);
//        int reward=orderService.getOrderRewardCount(phone);
        int msgCount=sjService.getMsgCount(phone,session);
        int shenSuCount=sjService.getShensuCount(phone,session);
        List<NoticVo> notics=noticeService.getNoticList();
        ShangJia sj=sjService.getShangJia(phone);
        HomeVo hvo=new HomeVo();
        hvo.setRefund(stateCountVo.getDaiFanKuan());
        hvo.setReward(stateCountVo.getDaiYongJin());
        hvo.setMsgCount(msgCount);
        hvo.setShenSuCount(shenSuCount);
        hvo.setNoticList(notics);
        hvo.setsMoney(sj.getSelfMoney());
        hvo.setYjMoney(sj.getYongjinMoney());
        hvo.setYtMoney(sj.getYaoqingMoney());
        hvo.setIsC(sj.getsCheck());
        hvo.setId(sj.getId());
        hvo.setPhone(sj.getPhone());
        return hvo;
    }
}
