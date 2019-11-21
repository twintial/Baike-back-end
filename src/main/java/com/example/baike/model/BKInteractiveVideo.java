package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BKInteractiveVideo extends BKUserSearch {
    private Integer uID;
    private Integer interVideoID;
    private String introduction;
    private Integer playVolume;
    private Integer praisePoint;
    private Integer collectPoint;
    private String tag;
    private Integer state;
    private Date uploadTime;
    private Integer initVideoID;
    private String icon;
}
