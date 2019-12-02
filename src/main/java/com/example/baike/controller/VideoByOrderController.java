package com.example.baike.controller;

import com.example.baike.mapper.SearchResultMapper;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.service.VideoByOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
//控制类
@RestController
@RequestMapping("/api")
public class VideoByOrderController {
    @Autowired
    VideoByOrderService videoByOrderService;
    @Autowired
    SearchResultMapper searchResultMapper;
    
    @GetMapping("/playVolume")
    List<BKInteractiveVideo> selectByPlayVolume(){
        return videoByOrderService.selectByPlayVolume();
    }



    @GetMapping("/time")
    List<BKInteractiveVideo> selectByTime(){
        return videoByOrderService.selectByTime();
    }

}
