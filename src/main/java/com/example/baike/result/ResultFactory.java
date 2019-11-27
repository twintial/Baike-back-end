package com.example.baike.result;

/**
 * @description 响应结果生成工厂类
 * @author WANGJIHONG
 * @date 2018年3月13日 下午8:36:58
 * @Copyright 版权所有 (c) www.javalsj.com
 * @memo 无备注说明
 */
public class ResultFactory {
    public static Result buildCustomResult(Integer code, String message, Object data){
        return new Result(code, message, data);
    }
    public static Result buildSuccessResult(Object data) {
        return buildSuccessWithMsg("success", data);
    }
    public static Result buildSuccessWithMsg(String message, Object data){
        return buildResult(ResultCode.SUCCESS.code, message, data);
    }
    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL.code, message, null);
    }


    private static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}

