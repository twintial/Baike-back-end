package com.example.baike.controller;

//Slf4j记录日志

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKUserSearch;
import com.example.baike.service.SearchVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
//控制类
@RestController

@RequestMapping("/api")
public class SearchVideoController {
    @Autowired
    SearchVideoService searchVideoService;


    @GetMapping("/SearchVideo/{title}")
    public List<BKInteractiveVideo> Search(@PathVariable("title") String SearchName){
        List<BKInteractiveVideo>p= searchVideoService.selectByName(SearchName);
        return p;
    }

}
