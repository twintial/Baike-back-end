package com.example.baike.controller;

import com.example.baike.MD5Util;
import com.example.baike.model.BKRegisterInfo;
import com.example.baike.model.BKUser;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.RegisterService;
import com.example.baike.service.SelectionHelperService;
import com.example.baike.state.UserState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @Autowired
    SelectionHelperService selectionHelperService;

    @PostMapping("/register")
    public Result register(@Valid @RequestBody BKRegisterInfo registerInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String msg = String.format("注册失败，%s。",
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(msg);
        }
        if (selectionHelperService.selectByNickName(registerInfo.getNickName()) != null){
            return ResultFactory.buildFailResult("用户名已存在");
        }
        if (selectionHelperService.selectByAccount(registerInfo.getAccount()) != null){
            return ResultFactory.buildFailResult("邮箱已存在");
        }
        return registerService.register(registerInfo.getAccount(),
                registerInfo.getPassword(), registerInfo.getNickName());
    }
}
