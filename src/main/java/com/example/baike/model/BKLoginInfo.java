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
    @Email(message = "account must be a e-mail address")
    @NotBlank(message = "account can't be empty")
    private String account;

    /**
     * 用户密码
     */
    @NotBlank(message = "password can't be empty")
    private String password;
}
