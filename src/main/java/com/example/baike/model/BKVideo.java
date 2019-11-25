package com.example.baike.model;

import lombok.Data;

@Data
public class BKVideo {
    /**
     * 视频id
     */
    private Integer videoID;

    /**
     * 属于的互动视频id
     */
    private Integer interVideoID;

    /**
     * 视频连接
     */
    private String videoURL;

    /**
     * 视频名
     */
    private String title;
}
