package com.example.baike.service.impl;

import com.example.baike.mapper.InteractiveVideoMapper;
import com.example.baike.model.BKNextVideo;
import com.example.baike.model.BKVideo;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    InteractiveVideoMapper interactiveVideoMapper;
    @Override
    public Result findURLANDNextVideosByNowVID(Integer vID) {
        List<BKNextVideo> nextVideos = interactiveVideoMapper.selectNextVideoByNowVID(vID);
        BKVideo video = interactiveVideoMapper.selectVideoByVID(vID);
        return ResultFactory.buildSuccessWithMsg(video.getVideoURL(), nextVideos);
    }
}
