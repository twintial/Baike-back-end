package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode()
@Data
public class BKSearchUserListViewModel implements Serializable {
    private List<BKSearchUser> list;
    private List<Integer> follow;
    private List<Integer> video;
    private Integer pageNum;
    public BKSearchUserListViewModel(List<BKSearchUser> a,Integer b,List<Integer> c,List<Integer> d){
        list=a;
        pageNum=b;
        follow=c;
        video=d;
    }
}
