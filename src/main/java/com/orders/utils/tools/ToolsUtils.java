package com.orders.utils.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.service.shensu.ShenSuServiceImpl;
import com.orders.utils.statecode.TaskType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.PanelUI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ToolsUtils {
    private static Logger log= LoggerFactory.getLogger(ToolsUtils.class);

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
            log.error(e.getMessage());
        }
        return "";
    }
    
    public static String showDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static String  showDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static Date toDate(String dateStr){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      try {
          return simpleDateFormat.parse(dateStr);
      }catch (Exception e){
        log.error(e.getMessage());
      }
      return new Date();
    }

    public static Date newToDay(){
        return new Date();
    }

    public static long getCurrentTime(){
        return new Date().getTime();
    }

    public static boolean checkOrderTimeOut(String date,int endHour){
        Date now=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            now = simpleDateFormat.parse(simpleDateFormat.format(now));
            Date before = simpleDateFormat.parse(date);
            if(before.before(now)){
                return false;
            }
            if(endHour<now.getHours()){
                return false;
            }
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return false;
    }

    public static boolean isVIPQuoQi(String quiQi){
        if(null==quiQi){
            return true;
        }
        Date now=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Date temp=simpleDateFormat.parse(quiQi);
            long diff=now.getTime()-temp.getTime();
            long day=diff/(1000*60*60*24);
            if(day< TaskType.DAY_28){
                return false;
            }else if(day<TaskType.DAY_29){
                return false;
            }else if(day<TaskType.DAY_30){
                return false;
            }else if(day<TaskType.DAY_31){
                return false;
            }
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return false;
    }

    /**
     * 判断当前连接是否过期
     * 当前时间-任务开始时间
     * 获得的差值/设定的间隔时间，小于1的说明连接没有过期，大于1的说明连接过期，
     * 获得上一个过期时间
     *
     *
     *
     * @param fromTime 任务开始时间
     * @param endTime  任务结束时间
     * @param jianGe   任务间隔时间
     * @return
     */
    public static long getLinkQuoQiTime(String day,String fromTime,String endTime,int jianGe){
        StringBuilder sb=new StringBuilder();
        sb.append(day);
        sb.append(" ");
        sb.append(fromTime);
        try {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            long qqt = sdFormat.parse(sb.toString()).getTime();
            long diff=System.currentTimeMillis()-qqt;
            double beiShu=((diff % (1000 * 60 * 60)) / (1000 * 60))/jianGe;
            int bs=(int)beiShu;
            long qqTime=(((bs*jianGe)+jianGe)*1000*60*60);
            return qqt+qqTime;

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return 0;
    }

    /**
     * 判断当前连接是否过期
     * @param qqTime
     * @return
     */
    public static boolean isLinkQuoQi(long qqTime){
        if(qqTime<System.currentTimeMillis()){
            return true;
        }
        return false;
    }

    public static String toJsonStrValue(Object obj){
        try {
            ObjectMapper objMapper = new ObjectMapper();
            return objMapper.writeValueAsString(obj);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "";
    }


}
