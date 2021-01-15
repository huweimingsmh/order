package com.orders.utils.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.dao.Message;
import com.orders.utils.statecode.TaskType;
import com.orders.vo.ShowTaskMessageVo;

import java.util.List;

public class LogicUtils {

    public static String getTaskType(int type){
        switch(type){
            case TaskType.BUY_TASK:
                return "购买任务";


        }
        return "";
    }
}
