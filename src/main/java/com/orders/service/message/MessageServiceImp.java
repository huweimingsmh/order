package com.orders.service.message;

import com.orders.dao.Message;
import com.orders.service.MessageService;

import java.util.List;

public class MessageServiceImp implements MessageService {
    @Override
    public List<Message> getSystemMessageBySJ(String phone) {
        return null;
    }

    @Override
    public List<Message> getSystemMessageByBuyer(String phone) {
        return null;
    }

    @Override
    public List<Message> getTaskMessageBySJ(String phone) {
        return null;
    }

    @Override
    public List<Message> getTaskMessageByBuyer(String phone) {
        return null;
    }

    @Override
    public List<Message> getTaskMessageBySubTask(String stId) {
        return null;
    }

    @Override
    public List<Message> getTaskMessageByWW(String ww) {
        return null;
    }

    @Override
    public List<Message> getTaskMessageByOid(String vip) {
        return null;
    }

    @Override
    public void createMessage() {

    }

    @Override
    public String lookSubTaskInfo() {
        return null;
    }
}
