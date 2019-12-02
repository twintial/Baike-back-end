package com.example.baike.service.impl;

import com.example.baike.mapper.VideoByOrderMapper;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.service.VideoByOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoByOrderServiceImpl implements VideoByOrderService {
    @Autowired
    VideoByOrderMapper videoByOrderMapper;

    @Override
    public List<BKInteractiveVideo> selectByPlayVolume() {
        return videoByOrderMapper.selectByPlayVolume();
    }

    @Override
    public List<BKInteractiveVideo> selectByCollectVolume() {
        return videoByOrderMapper.selectByCollectVolume();
    }

    @Override
    public List<BKInteractiveVideo> selectByPraiseVolume() {
        return videoByOrderMapper.selectByPraiseVolume();
    }

    @Override
    public List<BKInteractiveVideo> selectByTime() {
        return videoByOrderMapper.selectByTime();
    }
}
