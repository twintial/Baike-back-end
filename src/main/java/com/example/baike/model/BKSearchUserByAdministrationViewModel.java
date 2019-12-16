package com.example.baike.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode()
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BKSearchUserByAdministrationViewModel implements Serializable {
    private List<BKUserState> list;
    private Integer pageNum;
}
