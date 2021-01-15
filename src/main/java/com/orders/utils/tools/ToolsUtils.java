package com.orders.utils.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ToolsUtils {

    public static String forwordPage(String key,String page) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(key,page);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(map);
        }catch(JsonProcessingException e){

        }
        return "";
    }

    public  static boolean isOnline(String phone, HttpSession session){
        if(session.isNew()){
            return false;
        }
        if(session.getAttribute(phone)!=null){
            return true;
        }
        return false;
    }

    /**
     * 返回前端错误信息提示
     * @param errorContext
     * @return
     */
    public static String showError(String errorContext){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("error",errorContext);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(map);
        }catch(JsonProcessingException e){

        }
        return "";
    }
    
    public static String showDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


}
