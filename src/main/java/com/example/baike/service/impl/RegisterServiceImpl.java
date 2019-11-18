package com.example.baike.service.impl;

import com.example.baike.mapper.RegisterMapper;
import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;
import com.example.baike.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public Long userRegister(BKUser user) {
        return registerMapper.userRegister(user);
    }

    @Override
    public Long addInfo(BKUserInfo info) {
        return registerMapper.addInfo(info);
    }

    @Override
    public Long rollBackUser(BKUser user) {
        return registerMapper.rollBackUser(user);
    }
}
