package com.example.baike.result;

import lombok.Data;

@Data
public class ResourceResult {
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 错误信息
     */
    private String error;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 资源类型(格式:'.类型')
     */
    private String type;
}
