package com.example.baike.service.impl;

import com.example.baike.MD5Util;
import com.example.baike.mapper.RegisterMapper;
import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.RegisterService;
import com.example.baike.state.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    private static final String DEFAULT_USER_ICON = "static/userIcon/default.jpg";
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public Result register(String account, String pwd, String nickName) {

        // 添加用户
        BKUser user = new BKUser();
        user.setAccount(account);
        user.setPassword(pwd);
        // md5加密
        MD5Util.encrypt(user);
        try {
            registerMapper.userRegister(user);
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
        userInfo.setNickName(nickName);
        userInfo.setState(UserState.NORMAL);
        userInfo.setIconURL(DEFAULT_USER_ICON);
        try{
            registerMapper.addInfo(userInfo);
        }catch (Exception e){
            // 基本不会触发,之后改成事物回滚
            registerMapper.rollBackUser(user);
            return ResultFactory.buildFailResult("用户名已存在, 且用户回滚");
        }
        return ResultFactory.buildSuccessResult("用户注册成功");
    }

}
