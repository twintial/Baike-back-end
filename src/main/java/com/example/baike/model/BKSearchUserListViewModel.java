package com.example.baike.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode()
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BKSearchUserListViewModel implements Serializable {
    private List<BKSearchUser> list;
    private Integer pageNum;
    private List<Integer> follow;
    private List<Integer> video;
}
