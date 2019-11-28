package com.example.baike.controller;

import com.example.baike.result.Result;
import com.example.baike.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class VideoController {

    @Autowired
    VideoService videoService;
    @GetMapping("/video/next/{videoID}")
    public Result getNextVideo(@PathVariable("videoID") Integer videoID){
        return videoService.findURLANDNextVideosByNowVID(videoID);
    }
}
