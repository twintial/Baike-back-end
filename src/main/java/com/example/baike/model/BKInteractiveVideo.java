package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode()
@Data
public class BKInteractiveVideo implements Serializable {
    private Integer uID;
    private Integer interVideoID;
    private String introduction;
    private Integer playVolume;
    private Integer praisePoint;
    private Integer collectPoint;
    private String tag;
    private Integer state;
    private String uploadTime;
    private Integer initVideoID;
    private String icon;
    private String videoName;
}
