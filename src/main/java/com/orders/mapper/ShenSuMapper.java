package com.orders.mapper;

import com.orders.dao.ShenSu;
import com.orders.vo.ShenSuNewVo;
import com.orders.vo.ShenSuRVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShenSuMapper {
    /**
     * 获得申诉列表
     * @param phone
     * @return
     */

    public List<ShenSu> getShenSu(String phone);

    /**
     * 获得我发起的申诉
     * @param phone
     * @return
     */

    public List<ShenSu> getShenSuByBuilder(String phone);

    /**
     *获得我收到的申诉
     * @param phone
     * @return
     */
    public List<ShenSu> getShenSuByAccpter(String phone);

    /**
     *商家发起的申诉
     * @param phone
     * @return
     */
    public List<ShenSu> getShenSuBySJ(String phone);

    /**
     *买手发起的申诉
     * @param phone
     * @return
     */
    public List<ShenSu> getShenSuByB(String phone);

    /**
     *按申诉状态获得
     * @param phone
     * @param state
     * @return
     */
    public List<ShenSu> getShenSuByState(String phone,int state);

    /**
     *按子任务ID获得
     * @param stId
     * @return
     */
    public List<ShenSu> getShenSuBySt(String stId);

    /**
     *按商家手机号获得
     * @param phone
     * @return
     */
    public List<ShenSu> getShenSuBySJPhone(String phone);

    /**
     *按店铺名获得
     * @param name
     * @return
     */
    public List<ShenSu> getShenSuByShopName(String shopName);

    /**
     *按买手手机号获得
     * @param phone
     * @return
     */
    public List<ShenSu> getShenSuByBPhone(String phone);

    /**
     *按接单账号获得
     * @param ttVip
     * @return
     */
    public List<ShenSu> getShenSuByVip(String ttVip);

    /**
     *按订单号获得
     * @param oid
     * @return
     */
    public List<ShenSu> getShenSuByOid(String oid);

    /**
     *发起申诉
     */
    public void buildShenSu(ShenSu ss);
}
