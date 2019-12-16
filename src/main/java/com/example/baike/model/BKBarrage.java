package com.example.baike.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BKBarrage implements Serializable {
    /**
     * 发送弹幕的用户id
     */
    private Integer uID;

    /**
     * 弹幕所在的单个视频id
     */
    private Integer videoID;

    /**
     * 弹幕内容
     */
    private String content;

    /**
     * 弹幕发送时间
     */
    private Date sendTime;

    /**
     * 在视频中出现的时间
     */
    private Double videoTime;

    /**
     * 弹幕颜色
     */
    private String color;

    /**
     * 弹幕类型
     */
    private Integer bType;
}
