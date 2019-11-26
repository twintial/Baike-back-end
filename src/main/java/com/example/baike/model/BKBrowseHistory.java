package com.example.baike.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BKBrowseHistory implements Serializable {
    /**
     * 用户id
     */
    private Integer uID;

    /**
     * 观看的视频id
     */
    private Integer watchVideoID;

    /**
     * 观看日期
     */
    private Date watchDate;
}
