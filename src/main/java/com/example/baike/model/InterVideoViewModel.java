package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InterVideoViewModel extends BKInteractiveVideo {
    private String nickName;
}
