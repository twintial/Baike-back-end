package com.example.baike.service.impl;

import com.example.baike.mapper.ChangeStateMapper;
import com.example.baike.service.ChangeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeStateServiceImpl implements ChangeStateService {
    @Autowired
    ChangeStateMapper changeStateMapper;

    @Override
    public Long changeUser(Integer ID) {
        return changeStateMapper.changeUser(ID);
    }

    @Override
    public Long changeVideo(Integer ID) {
        return changeStateMapper.changeVideo(ID);
    }
}
