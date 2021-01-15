package com.orders.service;

import com.orders.vo.NoticNewVo;
import com.orders.vo.NoticVo;

import java.util.List;

public interface NoticeService {


    public List<NoticVo> getNoticList();

    public void createNotic(NoticNewVo vo);

    public NoticNewVo readNotic(long id);
}
