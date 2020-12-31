package com.orders.utils.statecode;

public interface StateCode {
    /**
     * 操作成功
     */
    int OK=1;
    /**
     * 密码错误
     */
    int PWD_ERROR=-1;
    /**
     * 两次输入的密码不一致
     */
    int PWD_RE_ERROR=-2;
    /**
     * 手机号错误
     */
    int PHONE_ERROR=-3;
    /**
     * 手机验证码错误
     */
    int PHONE_VALIDATE_ERROR=-4;

    /**
     * 唯一键异常（手机号已被注册)
     */
    int UNIQUE_ERROR=-5;
}
