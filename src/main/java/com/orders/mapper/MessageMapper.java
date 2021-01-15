package com.orders.mapper;

import com.orders.dao.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {


    public List<Message> getSystemMessageBySJ(String phone);

    /**
     * 买手获得管理员消息
     * @param phone
     * @return
     */
    public List<Message> getSystemMessageByBuyer(String phone);

    /**
     * 商家消息
     * @param phone
     * @return
     */
    public List<Message> getTaskMessageBySJ(String phone);

    /**
     * 买手消息
     * @param phone
     * @return
     */
    public List<Message> getTaskMessageByBuyer(String phone);

    /**
     * 按子任务获得消息
     * @param stId
     * @return
     */
    public List<Message> getTaskMessageBySubTask(String stId);

    /**
     * 按买手旺旺获得消息
     * @param ww
     * @return
     */
    public List<Message> getTaskMessageByWW(String ww);

    /**
     * 按订单号获得消息
     * @param vip
     * @return
     */

    public List<Message> getTaskMessageByOid(String vip);

    /**
     * 发送消息给某人，商家和买手共用
     */
    public void createMessage(Message msg);

    public String getOrderSTID(String oid);

    public String getTaskMessageContext(String stid);

    /**
     * 查看子任务详细
     * @return
     */
    public String lookSubTaskInfo();

    public void updateMessage(Message msg);
}
