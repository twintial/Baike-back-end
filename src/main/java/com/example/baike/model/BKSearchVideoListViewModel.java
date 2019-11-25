package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode()
@Data
public class BKSearchVideoListViewModel implements Serializable {
    private List<BKInteractiveVideo> list;
    private Integer pageNum;
    public BKSearchVideoListViewModel(List<BKInteractiveVideo> a,Integer b){
        list=a;
        pageNum=b;
    }
}
