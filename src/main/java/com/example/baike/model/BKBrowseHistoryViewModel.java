package com.example.baike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(callSuper = true)
@Data
public class BKBrowseHistoryViewModel  extends BKInteractiveVideo{
    /**
     * 观看日期
     */
    private Date watchDate;
}
