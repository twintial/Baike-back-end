package com.example.baike.controller;

//Slf4j记录日志

import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;
import com.example.baike.service.GetUIDService;
import com.example.baike.service.IsOnlineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
//控制类
@RestController

@RequestMapping("/api")
public class AppController {
    @Autowired
    IsOnlineService isOnlineService;
    @Autowired
    GetUIDService getUIDService;

    @PostMapping("/isOnline")
    public Integer test(HttpSession session){
        return isOnlineService.test(session);
    }

    @GetMapping("/getname/{uid}")
    public BKUserInfo Getname(@PathVariable("uid") Integer uid){
        return getUIDService.getUserInfoByID(uid);
    }
}
