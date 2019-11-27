package com.example.baike.constant;

import java.util.HashMap;

public class BarrageMap {
    public final static HashMap<String, Integer> typeMap = new HashMap<>();
    static {
        typeMap.put("right", 0);
        typeMap.put("top", 1);
        typeMap.put("bottom", 2);
    }
}
