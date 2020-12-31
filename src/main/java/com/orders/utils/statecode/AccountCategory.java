package com.orders.utils.statecode;

import java.net.PortUnreachableException;

public interface AccountCategory {

    /**
     * 本金充值
     */
    public int S_RECHARGE=1;
    /**
     * 本金支付
     */
    public int s_pay=-1;
    /**
     * 佣金充值
     */
    public int Y_RECHARGE=2;
    /**
     * 佣金支付
     */
    public int Y_PAY=-2;
    /**
     * 收益充值
     */

    public int I_RECHARGE=3;

     }
