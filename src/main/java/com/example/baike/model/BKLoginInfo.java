package com.example.baike.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BKLoginInfo implements Serializable {
    /**
     * 用户账号（邮箱）
     */
    @Email(message = "用户账号必须为邮箱名")
    @NotBlank(message = "用户账号不能为空")
    private String account;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    private String password;
}
