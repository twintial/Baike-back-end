package com.example.baike.controller;

import com.example.baike.MD5Util;
import com.example.baike.model.BKLoginInfo;
import com.example.baike.model.BKUser;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.LoginService;
import com.example.baike.service.impl.LoginServiceImpl;
import com.example.baike.state.UserState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.nimbus.State;
import javax.validation.Valid;
import java.util.Objects;

//Slf4j记录日志

@Slf4j
//控制类
@RestController

@RequestMapping("/api")
public class LoginController {
    @Autowired
    LoginService loginService;

    //Login的@PostMapping
    //@RequestBody 接受前端的json数据
    //此处@Valid验证BKLoginInfo的格式
    @PostMapping("/login")
    public Result Login(@Valid @RequestBody BKLoginInfo loginInfo, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()){
            String msg = String.format("登陆失败，%s。",
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(msg);
        }
        System.out.println("login");
        return loginService.login(loginInfo.getAccount(), loginInfo.getPassword(), session);
    }
}
