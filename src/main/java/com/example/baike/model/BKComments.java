package com.example.baike.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BKComments implements Serializable {
    /**
     * 用户id
     */
    private Integer uID;

    /**
     * 评论的视频id
     */
    private Integer interVideoID;

    /**
     * 评论
     */
    private String content;

    /**
     * 评论时间
     */
    private Date time;
}
