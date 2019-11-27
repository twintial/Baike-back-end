package com.example.baike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(callSuper = true)
@Data
public class BKVideoPlayVideoModel extends BKInteractiveVideo {

    /**
     * 初始视频
     */
    private BKVideo initVideo;

    /**
     * 此视频的用户信息
     */
    private BKUserInfo userInfo;

    /**
     * 此视频的评论
     */
    private List<CommentViewModel> comments;

    /**
     * 初始视频的下一个视频列表
     */
    private List<BKNextVideo> nextVideos;
}
