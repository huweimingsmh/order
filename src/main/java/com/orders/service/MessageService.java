package com.orders.service;

import com.orders.dao.Message;
import com.orders.vo.MessageContext;
import com.orders.vo.STMessageVo;
import com.orders.vo.ShowTaskMessageVo;
import com.orders.vo.SysMessageVo;

import java.util.List;

public interface MessageService {

    /**
     * 商家获得管理员消息
     * @param phone
     * @return
     */
    public  List<ShowTaskMessageVo> getSystemMessageBySJ(String phone);

    /**
     * 买手获得管理员消息
     * @param phone
     * @return
     */
    public  List<ShowTaskMessageVo> getSystemMessageByBuyer(String phone);

    /**
     * 商家消息
     * @param phone
     * @return
     */
    public  List<ShowTaskMessageVo> getTaskMessageBySJ(String phone);

    /**
     * 买手消息
     * @param phone
     * @return
     */
    public  List<ShowTaskMessageVo> getTaskMessageByBuyer(String phone);

    /**
     * 按子任务获得消息
     * @param stId
     * @return
     */
    public  List<ShowTaskMessageVo> getTaskMessageBySubTask(String stId);

    /**
     * 按买手旺旺获得消息
     * @param ww
     * @return
     */
    public  List<ShowTaskMessageVo> getTaskMessageByWW(String ww);

    /**
     * 按订单号获得消息
     * @param vip
     * @return
     */

    public  List<ShowTaskMessageVo> getTaskMessageByOid(String vip);

    /**
     * 按订单号获得子任务编号
     * @param oid
     * @return
     */
    public String getOrderSTID(String oid);

    /**
     * 按子任务编号获得聊天内容
     * @param stid
     * @return
     */
    public List<MessageContext> getTaskMessageContext(String stid);

    /**
     * 发送消息给某人，商家和买手共用
     */
    public void createMessage(STMessageVo vo);
    public void createSystemMessage(SysMessageVo vo);

    /**
     * 查看子任务详细
     * @return
     */
   // public String lookSubTaskInfo();

    public int getMessageCount(String phone);


}
