package com.example.baike.service.impl;

import com.example.baike.mapper.AdminLoginMapper;
import com.example.baike.service.AdminDetection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminDetectionImpl implements AdminDetection {
    @Autowired
    AdminLoginMapper adminLoginMapper;

    @Override
    public String Detection(String account, String psd) {
        if (adminLoginMapper.Detection(account,psd)!=null) return "true";
        else return "false";
    }
}
