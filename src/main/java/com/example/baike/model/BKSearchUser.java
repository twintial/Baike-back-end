package com.example.baike.model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BKSearchUser implements Serializable {

    /**
     * 用户唯一ID
     */
    @NotNull(message = "ID can't be empty")
    private Integer uID;

    /**
     * 用户昵称
     */
    @NotBlank(message = "nickname can't be empty")
    private String nickName;

    /**
     * 用户头像url
     */
    @NotBlank(message = "user icon can't be empty")
    private String iconURL;

    private String introduction;

}
