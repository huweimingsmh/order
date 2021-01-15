package com.orders.controller.notice;

import com.orders.service.NoticeService;
import com.orders.vo.NoticNewVo;
import com.orders.vo.NoticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticService;
    public void createNotice(@RequestBody NoticNewVo vo){
        if(null!=vo){
            noticService.createNotic(vo);
        }
    }

    public NoticNewVo readNotice(@RequestBody String id){
       return noticService.readNotic(Long.valueOf(id));
    }

    public List<NoticVo> getNoticeList(){
        return noticService.getNoticList();
    }
}
