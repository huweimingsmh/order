package com.orders.service.shensu;

import com.orders.dao.Order;
import com.orders.dao.ShenSu;
import com.orders.mapper.OrderMapper;
import com.orders.mapper.ShenSuMapper;
import com.orders.service.ShenSuService;
import com.orders.service.shangjia.ShangJiaServiceImp;
import com.orders.utils.statecode.ShenSuType;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.ShenSuNewVo;
import com.orders.vo.ShenSuRVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value="shenSuService")
public class ShenSuServiceImpl implements ShenSuService {
    private static Logger log= LoggerFactory.getLogger(ShenSuServiceImpl.class);

    @Autowired
    private ShenSuMapper shensuMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<ShenSuRVo> getShenSu(String phone) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSu(phone);

            return getShenSuRVo(ssL);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByBuilder(String phone) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuByBuilder(phone);
            return getShenSuRVo(ssL);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByAccpter(String phone) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuByAccpter(phone);
            return getShenSuRVo(ssL);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return  new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuBySJ(String phone) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuBySJ(phone);
            return getShenSuRVo(ssL);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByB(String phone) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuByB(phone);
            return getShenSuRVo(ssL);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByState(String phone, int state) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuByState(phone, state);
            return getShenSuRVo(ssL);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByStid(String stId) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuBySt(stId);
            return getShenSuRVo(ssL);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuBySJPhone(String phone) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuBySJPhone(phone);
            return getShenSuRVo(ssL);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByShopName(String name) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuByShopName(name);
            return getShenSuRVo(ssL);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByBPhone(String phone) {
        try{
            List<ShenSu> ssL= shensuMapper.getShenSuByBPhone(phone);
            return getShenSuRVo(ssL);
        }catch (Exception e){
            log.error(e.getMessage());
        }
      return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByVip(String ttVip) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuByVip(ttVip);
            return getShenSuRVo(ssL);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShenSuRVo> getShenSuByOid(String oid) {
        try {
            List<ShenSu> ssL = shensuMapper.getShenSuByOid(oid);
            return getShenSuRVo(ssL);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }


    private  List<ShenSuRVo> getShenSuRVo(List<ShenSu>  shenSus){
        if(null!=shenSus && shenSus.size()>0){
            List<ShenSuRVo> vos=new ArrayList<>();
            ShenSuRVo rvo=null;
            for(ShenSu ss:shenSus){
                rvo=new ShenSuRVo();
                rvo.setAsk(ss.getAsk());
                rvo.setBuilder(ss.getBuilder()== ShenSuType.BUY_BUILDER?"买手":"商家");
                rvo.setIsIn(ss.getIsIn()==ShenSuType.P_IN?"是":"否");
                switch(ss.getState()){
                    case ShenSuType.SS_CANCEL:
                        rvo.setState("取消");
                        break;
                    case ShenSuType.SS_CLOSE:
                        rvo.setState("关闭");
                        break;
                    case ShenSuType.SS_ING:
                        rvo.setState("申诉中");
                        break;
                }
                String[] tempImgs=ss.getImage().split(",");
                rvo.setImages(tempImgs);
                rvo.setStId(ss.getStId());
                rvo.setSsTime(ss.getSsTime());
                rvo.setTitle(ss.getTitle());
                vos.add(rvo);
            }
            return vos;
        }
        return new ArrayList<>();
    }
    @Override
    public void buildShenSu(ShenSuNewVo vo) {
        try {
            if (null != vo) {
                ShenSu ss = new ShenSu();
                Order order = orderMapper.getOrderByStid(vo.getStid());

                ss.setAsk(vo.getProblem() + "/r/n" + vo.getAsk());
                ss.setbPhone(order.getbPhone());
                ss.setBuilder(vo.getBuilder());
                String[] tempImg = vo.getImages();
                ss.setImage(tempImg[0] + "," + tempImg[1]);
                ss.setIsIn(ShenSuType.P_NO);
                ss.setState(ShenSuType.SS_ING);
                ss.setTitle(vo.getTitle());
                if (vo.getBuilder() == ShenSuType.BUY_BUILDER) {
                    ss.setSsPhone(order.getbPhone());
                    ss.setaPhone(order.getSjPhone());
                } else {
                    ss.setSsPhone(order.getSjPhone());
                    ss.setaPhone(order.getbPhone());
                }
                ss.setShopName(order.getShopName());
                ss.setSjPhone(order.getSjPhone());
                ss.setbPhone(order.getbPhone());
                ss.setTaobaoVip(order.getTaobaoVip());
                ss.setStId(order.gettId());
                ss.setSsTime(ToolsUtils.showDate());
                ss.setoId(order.getoId());
                shensuMapper.buildShenSu(ss);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public int getShenSuCount(String phone) {
        return 0;
    }
}
