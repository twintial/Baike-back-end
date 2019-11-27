package com.example.baike.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    /**
     * 响应状态码
     */
    private int code;
    /**
     * 响应提示信息
     */
    private String msg;
    /**
     * 响应结果对象
     */
    private Object data;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }


}

