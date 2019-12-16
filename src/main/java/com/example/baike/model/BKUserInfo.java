package com.example.baike.model;

import com.example.baike.constant.state.UserState;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BKUserInfo implements Serializable {

    /**
     * 用户唯一ID
     */
    @NotNull(message = "id can't be empty")
    private Integer uID;

    /**
     * 用户昵称
     */
    @NotBlank(message = "nickname can't be empty")
    private String nickName;

    /**
     * 用户头像url
     */
    @NotBlank(message = "用户头像不可为空")
    private String iconURL;

    /**
     * 用户状态
     */
    @NotNull(message = "用户状态不可为空")
    private UserState state;

    /**
     * 用户简介
     */
    private String introduction;

    /**
     * 用户背景图
     */
    private String backgroundIconURL;
}
