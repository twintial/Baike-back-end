package com.example.baike.controller;

//Slf4j记录日志

import com.example.baike.service.IsOnlineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
//控制类
@RestController

@RequestMapping("/api")
public class IsOnlineController {
    @Autowired
    IsOnlineService isOnlineService;

    @PostMapping("/isOnline")
    public boolean test(HttpSession session){
        return isOnlineService.test(session);
    }
}
