package com.example.baike.service.impl;

import com.example.baike.util.MD5Util;
import com.example.baike.mapper.LoginMapper;
import com.example.baike.model.BKUser;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.LoginService;
import com.example.baike.constant.state.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public Result login(String account, String psw, HttpSession session) {
        if (session.getAttribute("user") != null){
            return ResultFactory.buildFailResult("already login");
        }
        BKUser user;
        UserState state;
        try {
            user = loginMapper.selectByAccount(account);
            state = loginMapper.selectStateByUID(user.getUID());
        }catch (Exception e){
            return ResultFactory.buildFailResult("e-mail address don't exist");
        }
        if (state.equals(UserState.BANNED)){
            return ResultFactory.buildFailResult("you have been banned, please contact administrator first");
        }
        // md5加密
        String salt = user.getSalt();

        String MD5Pwd = MD5Util.getMD5Pwd(psw, salt);
        if (MD5Pwd.equals(user.getPassword())){
            // session存储
            session.setAttribute("user", user);
            return ResultFactory.buildSuccessResult(user.getAccount());
        }
        return ResultFactory.buildFailResult("error password");
    }
}
