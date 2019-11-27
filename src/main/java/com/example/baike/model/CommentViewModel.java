package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommentViewModel extends BKComments {
    /**
     * 用户头像
     */
    private String icon;

    /**
     * 用户名称
     */
    private String nickName;
}
