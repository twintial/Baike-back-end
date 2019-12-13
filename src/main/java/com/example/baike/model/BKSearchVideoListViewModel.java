package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode()
@Data
public class BKSearchVideoListViewModel implements Serializable {
    private List<InterVideoViewModel> list;
    private Integer pageNum;
    public BKSearchVideoListViewModel(List<InterVideoViewModel> a,Integer b){
        list=a;
        pageNum=b;
    }
}
