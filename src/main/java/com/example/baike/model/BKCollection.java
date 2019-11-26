package com.example.baike.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BKCollection implements Serializable {
    /**
     * 用户id
     */
    private Integer uID;

    /**
     * 收藏的视频id
     */
    private Integer favVideoID;
}
