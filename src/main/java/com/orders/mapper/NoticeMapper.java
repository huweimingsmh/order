package com.orders.mapper;

import com.orders.vo.NoticNewVo;
import com.orders.vo.NoticVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NoticeMapper {
    public List<NoticVo> getNoticList();

    public void createNotic(NoticNewVo vo);

    public NoticNewVo readNotic(long id);
}
