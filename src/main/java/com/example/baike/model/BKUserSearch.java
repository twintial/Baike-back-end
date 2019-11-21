package com.example.baike.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BKUserSearch implements Serializable {
    @NotBlank(message = "请输入搜索内容！")
    private String SearchName;
}
