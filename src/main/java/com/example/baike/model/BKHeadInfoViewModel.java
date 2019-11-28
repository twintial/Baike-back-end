package com.example.baike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(callSuper = true)
@Data
public class BKHeadInfoViewModel extends BKUserInfo{
    /**
     * 用户上传视频数量
     */
    private Integer uploadVideoNum;

    /**
     * 用户喜欢视频数量
     */
    private Integer favVideoNum;

    /**
     * 用户跟随者数量
     */
    private Integer userFollowerNum;

    /**
     * 用户跟随的人数量
     */
    private Integer usersFollowNum;
}
