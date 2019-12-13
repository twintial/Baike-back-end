package com.example.baike.controller;

import com.example.baike.model.BKBarrageViewModel;
import com.example.baike.model.ReadBarrageViewModel;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.BarrageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/api")
public class BarrageController {

    @Autowired
    BarrageService barrageService;
    @GetMapping("/danmaku/v2/{vID}")
    public Result read(@PathVariable Integer vID){
        Object[][] barrages = barrageService.selectAllBarragesByID(vID);
        return ResultFactory.buildCustomResult(1, "success", barrages);
    }

    @PostMapping("/danmaku/v2")
    public Result send(@RequestBody BKBarrageViewModel barrageVideoModel, HttpSession session){
        return barrageService.insertBarrage(barrageVideoModel, session);
    }
}
