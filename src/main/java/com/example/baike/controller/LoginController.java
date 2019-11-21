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
            String msg = String.format("注册失败，详细信息[%s]。",
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(msg);
        }
        if (session.getAttribute("user") != null){
            return ResultFactory.buildFailResult("已经登陆了啦");
        }
        BKUser user;
        UserState state;
        log.info(loginInfo.getAccount());
        try {
            log.info("dd");
            log.info(loginService.toString());
            log.info("aa");
            user = loginService.selectByAccount(loginInfo.getAccount());
            state = loginService.selectStateByUID(user.getUID());
        }catch (Exception e){
            return ResultFactory.buildFailResult(e.toString());
        }
        if (state.equals(UserState.BANNED)){
            return ResultFactory.buildFailResult("用户被封禁");
        }
        // md5加密
        String salt = user.getSalt();
        String MD5Pwd = MD5Util.getMD5Pwd(loginInfo.getPassword(), salt);
        if (MD5Pwd.equals(user.getPassword())){
            // session存储
            session.setAttribute("user", user);
            return ResultFactory.buildSuccessResult(user.getAccount());
        }
        return ResultFactory.buildFailResult("密码错误");
    }
}
