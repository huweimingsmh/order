package com.orders.service;

import com.orders.vo.ShenSuRVo;

import java.util.List;

public interface ShenSuService {
    /**
     * 获得申诉列表
     * @param phone
     * @return
     */

    public List<ShenSuRVo> getShenSu(String phone);

    /**
     * 获得我发起的申诉
     * @param phone
     * @return
     */

    public List<ShenSuRVo> getShenSuByBuilder(String phone);

    /**
     *获得我收到的申诉
     * @param phone
     * @return
     */
    public List<ShenSuRVo> getShenSuByAccpter(String phone);

    /**
     *商家发起的申诉
     * @param phone
     * @return
     */
    public List<ShenSuRVo> getShenSuBySJ(String phone);

    /**
     *买手发起的申诉
     * @param phone
     * @return
     */
    public List<ShenSuRVo> getShenSuByB(String phone);

    /**
     *按申诉状态获得
     * @param phone
     * @param state
     * @return
     */
    public List<ShenSuRVo> getShenSuByState(String phone,int state);

    /**
     *按子任务ID获得
     * @param stId
     * @return
     */
    public List<ShenSuRVo> getShenSuBySt(String stId);

    /**
     *按商家手机号获得
     * @param phone
     * @return
     */
    public List<ShenSuRVo> getShenSuBySJPhone(String phone);

    /**
     *按店铺名获得
     * @param name
     * @return
     */
    public List<ShenSuRVo> getShenSuByShopName(String name);

    /**
     *按买手手机号获得
     * @param phone
     * @return
     */
    public List<ShenSuRVo> getShenSuByBPhone(String phone);

    /**
     *按接单账号获得
     * @param ttVip
     * @return
     */
    public List<ShenSuRVo> getShenSuByVip(String ttVip);

    /**
     *按订单号获得
     * @param oid
     * @return
     */
    public List<ShenSuRVo> getShenSuByOid(String oid);

    /**
     *发起申诉
     */
    public void buildShenSu();


}
