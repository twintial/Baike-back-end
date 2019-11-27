package com.example.baike.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BKBarrageViewModel implements Serializable {
    private Integer Player;
    private String color;
    private String author;
    private Double time;
    private String text;
    private String type;
}
