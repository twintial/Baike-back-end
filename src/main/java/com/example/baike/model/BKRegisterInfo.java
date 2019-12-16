package com.example.baike.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BKRegisterInfo implements Serializable {
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

    /**
     * 用户昵称
     */
    @NotBlank(message = "nickname can't be empty")
    private String nickName;
}
