package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class BKUser extends BKLoginInfo {

    /**
     * 用户的唯一id
     */
    @NotNull(message = "id can't be empty")
    private Integer uID;

    /**
     * 盐值
     */
    private String salt;

}
