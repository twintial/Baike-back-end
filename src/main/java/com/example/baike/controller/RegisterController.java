package com.example.baike.controller;

import com.example.baike.BaikeApplication;
import com.example.baike.MD5Util;
import com.example.baike.mapper.SelectionHelperMapper;
import com.example.baike.model.BKRegisterInfo;
import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.RegisterService;
import com.example.baike.service.SelectionHelperService;
import com.example.baike.state.UserState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.State;
import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api")
public class RegisterController {
    private static final String DEFAULT_USER_ICON = "img/userIcon/default.jpg";
    @Autowired
    RegisterService registerService;
    @Autowired
    SelectionHelperService selectionHelperService;

    @PostMapping("/register")
    public Result register(@Valid @RequestBody BKRegisterInfo registerInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String msg = String.format("注册失败，详细信息[%s]。",
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(msg);
        }
        if (selectionHelperService.selectByNickName(registerInfo.getNickName()) != null){
            return ResultFactory.buildFailResult("用户名已存在");
        }
        if (selectionHelperService.selectByAccount(registerInfo.getAccount()) != null){
            return ResultFactory.buildFailResult("邮箱已存在");
        }

        // 添加用户
        BKUser user = new BKUser();
        user.setAccount(registerInfo.getAccount());
        user.setPassword(registerInfo.getPassword());
        // md5加密
        MD5Util.encrypt(user);
        try {
            registerService.userRegister(user);
        }catch (Exception e){
            // 基本不会触发
            return ResultFactory.buildFailResult("邮箱已存在, 且用户回滚");
        }
        if (user.getUID() == null){
            return ResultFactory.buildFailResult("注册失败");
        }
        // 添加用户信息
        BKUserInfo userInfo = new BKUserInfo();
        userInfo.setUID(user.getUID());
        userInfo.setNickName(registerInfo.getNickName());
        userInfo.setState(UserState.NORMAL);
        userInfo.setIconURL(DEFAULT_USER_ICON);
        try{
            registerService.addInfo(userInfo);
        }catch (Exception e){
            // 基本不会触发
            registerService.rollBackUser(user);
            return ResultFactory.buildFailResult("用户名已存在, 且用户回滚");
        }
        return ResultFactory.buildSuccessResult("用户注册成功");
    }
}
