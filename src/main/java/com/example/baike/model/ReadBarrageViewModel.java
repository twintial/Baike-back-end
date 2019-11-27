package com.example.baike.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReadBarrageViewModel implements Serializable {
//    private Integer code;
//    private Object[][] data;
//    private Object msg;
    /**
     * 弹幕在视频中的出现时间
     */
    private Double time;

    /**
     * 弹幕类型
     */
    private Integer bType;

    /**
     * 弹幕颜色
     */
    private Integer color;

    /**
     * 用户id(之后可能改成用户名)
     */
    private String uID;

    /**
     * 
     */
}
