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
public class BKSearchVideoListViewModel implements Serializable {
    private List<InterVideoViewModel> list;
    private Integer pageNum;
}
