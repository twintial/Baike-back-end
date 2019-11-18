package com.example.baike.result;

/**
 * @description 响应结果生成工厂类
 * @author WANGJIHONG
 * @date 2018年3月13日 下午8:36:58
 * @Copyright 版权所有 (c) www.javalsj.com
 * @memo 无备注说明
 */
public class ResultFactory {

    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "success", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    private static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    private static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}

