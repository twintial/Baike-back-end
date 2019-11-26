package com.example.baike.model;

import com.example.baike.state.VideoState;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
public class BKInteractiveVideo implements Serializable {
    /**
     * 互动视频idBK
     */
    private Integer interVideoID;

    /**
     * 互动视频名称
     */
    @NotBlank(message = "视频名称不能为空")
    private String videoName;

    /**
     * 互动视频简介
     */
    private String introduction;

    /**
     * 互动视频类别(有时间会改成category)
     */
    private String tag;

    /**
     * 此视频的用户id
     */
    private Integer uID;

    /**
     * 播放量
     */
    private Integer playVolume;

    /**
     * 点赞量
     */
    private Integer praisePoint;

    /**
     * 收藏量
     */
    private Integer collectPoint;

    /**
     * 状态
     */
    private VideoState state;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 封面图片
     */
    private String icon;

    /**
     * 初始视频id
     */
    private Integer initVideoID;
}
