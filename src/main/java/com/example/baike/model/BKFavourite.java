package com.example.baike.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BKFavourite implements Serializable {
    /**
     * 用户id
     */
    private Integer uID;

    /**
     * 关注的用户id
     */
    private Integer favUerID;
}
