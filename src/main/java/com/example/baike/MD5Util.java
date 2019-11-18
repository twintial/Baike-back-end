package com.example.baike;

import com.example.baike.model.BKUser;
import org.apache.catalina.User;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class MD5Util {
    public static void encrypt(BKUser user){
        String salt = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        String MD5pwd = getMD5Pwd(user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(MD5pwd);
    }

    public static String getMD5Pwd(String pwd, String salt){
        String str = salt + pwd +salt;
        for (int i = 0; i < 6; i++) {
            str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
        }
        return str;
    }
}
