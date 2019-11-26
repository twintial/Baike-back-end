package com.example.baike.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BKNextVideo implements Serializable {
    /**
     * 视频id
     */
    private Integer videoID;

    /**
     * 对应的下一个视频id
     */
    private Integer nextVideoID;

    /**
     * 对应的选项
     */
    private String choice;
}
