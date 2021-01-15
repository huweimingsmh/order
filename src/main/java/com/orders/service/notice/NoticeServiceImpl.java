package com.orders.service.notice;

import com.orders.mapper.NoticeMapper;
import com.orders.service.NoticeService;
import com.orders.vo.NoticNewVo;
import com.orders.vo.NoticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<NoticVo> getNoticList() {
        return noticeMapper.getNoticList();
    }

    @Override
    public void createNotic(NoticNewVo vo) {
        try {
            if (null != vo) {
                noticeMapper.createNotic(vo);
            }
        }catch (Exception e){

        }
    }

    @Override
    public NoticNewVo readNotic(long id) {
        return noticeMapper.readNotic(id);
    }
}
