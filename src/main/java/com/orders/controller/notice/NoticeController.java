package com.orders.controller.notice;

import com.orders.service.NoticeService;
import com.orders.vo.NoticNewVo;
import com.orders.vo.NoticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticService;

    @RequestMapping(value = "/newnotice", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void createNotice(@RequestBody NoticNewVo vo){
        if(null!=vo){
            noticService.createNotic(vo);
        }
    }

    @RequestMapping(value = "/readnotice", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public NoticNewVo readNotice(@RequestBody Map<String,Object> param){
        String id=(String)param.get("id");

        return noticService.readNotic(Long.valueOf(id));
    }

    @RequestMapping(value = "/gnlist", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<NoticVo> getNoticeList(){
        return noticService.getNoticList();
    }
}
