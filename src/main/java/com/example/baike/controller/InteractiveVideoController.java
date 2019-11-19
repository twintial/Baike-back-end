package com.example.baike.controller;

import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/api")
public class InteractiveVideoController {

    @GetMapping("/video/{vID}")
    public Result getIntVideo(@PathVariable @NotNull Integer vID){
        return ResultFactory.buildSuccessResult(vID);
    }
}
