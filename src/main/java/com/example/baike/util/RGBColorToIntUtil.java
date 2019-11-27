package com.example.baike.util;

public class RGBColorToIntUtil {
    // 输入如#FFFASD
    public static Integer RGBToInt(String rgb){
        String processedRGB = rgb.replace("#", "");
        if (processedRGB.length() < 6){
            processedRGB += processedRGB;
        }
        try {
            return Integer.parseInt(processedRGB, 16);
        }catch (Exception e){
            return null;
        }
    }
}
