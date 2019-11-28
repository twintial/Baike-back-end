package com.example.baike.controller;

import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import com.example.baike.service.EditVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api")
public class EditVideoController {
    @Autowired
    EditVideoService editVideoService;

    @GetMapping("/edit/{interVideoID}")
    public Result getVideoListByInterVID(@PathVariable @NotNull Integer interVideoID){
        return editVideoService.getVideoList(interVideoID);
    }

    @PostMapping("/edit")
    public Result getStructure(@RequestParam("ID") Integer IVID, @RequestParam("Structure") String structure) {
        return editVideoService.getInterVideoStructure(structure, IVID);
    }

}
