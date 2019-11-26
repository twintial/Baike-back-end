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
     * 弹幕所在的互动视频id
     */
    private Integer interVideoID;

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
    private Date videoTime;
}
