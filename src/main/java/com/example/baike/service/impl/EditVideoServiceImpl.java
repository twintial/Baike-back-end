package com.example.baike.service.impl;


import com.example.baike.mapper.InteractiveVideoMapper;
import com.example.baike.model.BKVideo;
import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.EditVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class EditVideoServiceImpl implements EditVideoService {
    @Autowired
    InteractiveVideoMapper interactiveVideoMapper;

    @Override
    public Result getVideoList(Integer InterVID){
        List<BKVideo> videos = interactiveVideoMapper.selectVideoByInterVID(InterVID);

        if (videos == null){
            return ResultFactory.buildFailResult("出现未知错误，获取视频列表失败");
        }
        else {
            return ResultFactory.buildSuccessResult(videos);
        }
    }

    @Override
    public ResourceResult getInterVideoStructure(MultipartFile file) throws IOException {

        ResourceResult result = new ResourceResult();

        return result;
    }
}
