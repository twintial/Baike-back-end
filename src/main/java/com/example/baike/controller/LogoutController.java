package com.example.baike.controller;
//Slf4j记录日志

import com.example.baike.service.LogoutService;
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
public class LogoutController {
    @Autowired
    LogoutService logoutService;

    @PostMapping("/logout")
    public void logout(HttpSession session){
        System.out.println("logout");
        logoutService.logout(session);
    }
}
