package com.example.baike.result;
/**
 * @description 响应码枚举，参考 HTTP状态码的语义
 * @author WANGJIHONG
 * @date 2018年3月13日 下午8:35:00
 * @Copyright 版权所有 (c) www.javalsj.com
 * @memo 无备注说明
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 失败
     */
    FAIL(400),

    /**
     * 弹幕发送成功
     */
    BARRAGE_SEND_SUCCESS(0),

    /**
     * 弹幕投放成功
     */
    BARRAGE_READ_SUCCESS(1);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }

}

