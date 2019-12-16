package com.example.baike.controller;

import com.example.baike.model.BKRegisterInfo;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.RegisterService;
import com.example.baike.service.SelectionHelperService;
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
            String msg = String.format("register fail，%s。",
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(msg);
        }
        if (selectionHelperService.selectByNickName(registerInfo.getNickName()) != null){
            return ResultFactory.buildFailResult("username have been used");
        }
        if (selectionHelperService.selectByAccount(registerInfo.getAccount()) != null){
            return ResultFactory.buildFailResult("e-mail address have been used");
        }
        return registerService.register(registerInfo.getAccount(),
                registerInfo.getPassword(), registerInfo.getNickName());
    }
}
