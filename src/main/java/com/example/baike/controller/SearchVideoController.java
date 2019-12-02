package com.example.baike.controller;

//Slf4j记录日志

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKSearchVideoListViewModel;
import com.example.baike.service.SearchVideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//控制类
@RestController
@RequestMapping("/api")
public class SearchVideoController {
    @Autowired
    SearchVideoService searchVideoService;


    @GetMapping("/SearchVideo/{title}/{tag}/{page}")
    public BKSearchVideoListViewModel Search(@PathVariable("title") String SearchName,
                                             @PathVariable("tag") String tag, @PathVariable("page") Integer page){
        return  searchVideoService.selectByName(SearchName,tag,page);
    }

    @GetMapping("/category/{tag}")
    List<BKInteractiveVideo> category(@PathVariable("tag") String tag){
        return searchVideoService.category(tag);
    }


}
