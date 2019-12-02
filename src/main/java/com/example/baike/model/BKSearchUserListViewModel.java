package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode()
@Data
public class BKSearchUserListViewModel implements Serializable {
    private List<BKSearchUser> list;
    private Integer pageNum;
    public BKSearchUserListViewModel(List<BKSearchUser> a,Integer b){
        list=a;
        pageNum=b;
    }
}
