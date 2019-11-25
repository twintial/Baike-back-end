package com.example.baike.constant;

import java.io.File;

public class ResourcePath {
    public final static String baseURL = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "resources" + File.separator;
    public final static String tempURL = "temp" + File.separator;
    public final static String coverImgDirURL(String interVideoID){
        return baseURL + "img" + File.separator
                + "videoCover" + File.separator + interVideoID + File.separator;
    }
    public static String videoDirURL(String interVideoID){
        return baseURL + "video" + File.separator + interVideoID + File.separator;
    }
}
