package com.example.baike.service.impl;

import com.example.baike.mapper.VideoByOrderMapper;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.InterVideoViewModel;
import com.example.baike.service.VideoByOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoByOrderServiceImpl implements VideoByOrderService {
    @Autowired
    VideoByOrderMapper videoByOrderMapper;

    @Override
    public List<InterVideoViewModel> selectByPlayVolume() {
        return videoByOrderMapper.selectByPlayVolume();
    }

    @Override
    public List<InterVideoViewModel> selectByCollectVolume() {
        return videoByOrderMapper.selectByCollectVolume();
    }

    @Override
    public List<InterVideoViewModel> selectByPraiseVolume() {
        return videoByOrderMapper.selectByPraiseVolume();
    }

    @Override
    public List<InterVideoViewModel> selectByTime() {
        return videoByOrderMapper.selectByTime();
    }
}
