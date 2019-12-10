package com.example.baike.service.impl;

import com.example.baike.mapper.AboutMeMapper;
import com.example.baike.model.BKUserInfo;
import com.example.baike.service.GetUIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUIDServiceImpl implements GetUIDService {
    @Autowired
    AboutMeMapper aboutMeMapper;

    @Override
    public BKUserInfo getUserInfoByID(Integer uID) {
        return aboutMeMapper.selectUserInfoByID(uID);
    }
}
