package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode()
@Data
public class BKSearchUserByAdministrationViewModel implements Serializable {
    private List<BKUserState> list;
    private Integer pageNum;
    public BKSearchUserByAdministrationViewModel(List<BKUserState> a,Integer b){
        list=a;
        pageNum=b;
    }
}
