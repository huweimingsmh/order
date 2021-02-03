package com.orders.service.home;

import com.orders.dao.maishou.Buyer;
import com.orders.dao.shangjia.ShangJia;
import com.orders.service.*;
import com.orders.vo.BuyHomeVo;
import com.orders.vo.HomeVo;
import com.orders.vo.NoticVo;
import com.orders.vo.order.OrderStateCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service(value="buyHomePageService")
public class BuyHomePageServiceImp implements BuyHomePageService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private MessageService mesageService;
    @Autowired
    private ShenSuService shenSuService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private BuyService buyService;

    @Override
    public BuyHomeVo getHomePageDate(String phone, HttpSession session) {
        OrderStateCountVo stateCountVo=orderService.getOrderRefundCount(phone);
       // int refund = orderService.getOrderRefundCount(phone);
       // int reward = orderService.getOrderRewardCount(phone);
        int msgCount = buyService.getMsgCount(phone,session);
        int shenSuCount = buyService.getShensuCount(phone,session);
        List<NoticVo> notics = noticeService.getNoticList();
        Buyer buy = buyService.getBuyer(phone);
        BuyHomeVo hvo = new BuyHomeVo();
        hvo.setRefund(stateCountVo.getDaiFanKuan());
        hvo.setReward(stateCountVo.getDaiYongJin());
        hvo.setMsgCount(msgCount);
        hvo.setShenSuCount(shenSuCount);
        hvo.setNoticList(notics);

        hvo.setId(buy.getId());
        hvo.setPhone(buy.getPhone());
        return hvo;
    }
}

