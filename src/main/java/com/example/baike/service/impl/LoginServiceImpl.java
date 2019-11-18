package com.example.baike.service.impl;

import com.example.baike.mapper.LoginMapper;
import com.example.baike.model.BKUser;
import com.example.baike.service.LoginService;
import com.example.baike.state.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public BKUser selectByAccount(String account) {
        return loginMapper.selectByAccount(account);
    }

    @Override
    public UserState selectStateByUID(Integer uID) {
        return loginMapper.selectStateByUID(uID);
    }
}
