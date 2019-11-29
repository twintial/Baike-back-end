package com.example.baike.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class BKComments implements Serializable {
    /**
     * 用户id
     */
    @NotNull(message = "Login Please")
    private Integer uID;

    /**
     * 评论的视频id
     */
    @NotNull(message = "video doesn't exist")
    private Integer interVideoID;

    /**
     * 评论
     */
    @NotBlank(message = "content can't be blank")
    private String content;

    /**
     * 评论时间
     */
    private Date sendTime;
}
