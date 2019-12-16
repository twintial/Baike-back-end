package com.example.baike.controller;

import com.example.baike.model.*;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.InteractiveVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.File;

import static com.example.baike.constant.ResourcePath.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class InteractiveVideoController {
    @Autowired
    InteractiveVideoService interactiveVideoService;
    @GetMapping("/video/{state}/{pageNum}")
    public Result getVideoByPage(@PathVariable String state, @PathVariable Integer pageNum, HttpSession session){
        return interactiveVideoService.getInteractiveVideoPage(state, pageNum ,session);
    }

    @DeleteMapping("/video/{interVideoID}")
    public Result deleteInteractiveVideo(@PathVariable Integer interVideoID){
        if (!interactiveVideoService.deleteFile(new File(coverImgDirURL(String.valueOf(interVideoID))))){
            return ResultFactory.buildFailResult("封面删除失败");
        }
        if (!interactiveVideoService.deleteFile(new File(videoDirURL(String.valueOf(interVideoID))))){
            return ResultFactory.buildFailResult("视频删除失败");
        }
        return interactiveVideoService.deleteInteractiveVideoByID(interVideoID);
    }

    @GetMapping("/video/{vID}")
    public Result getVideo(@PathVariable @NotNull Integer vID){
        return interactiveVideoService.findInterVideoInfoByVID(vID);
    }

    @PostMapping("/history")
    public Result insertHistory(@RequestBody BKBrowseHistory bkBrowseHistory){
        return interactiveVideoService.insertBrowseHistory(bkBrowseHistory);
    }

    @PostMapping("/insert/collection")
    public Result insertCollection(@RequestBody BKCollection collection){
        return interactiveVideoService.insertCollection(collection);
    }

    @DeleteMapping("/delete/collection/{uID}/{vID}")
    public Result deleteCollection(@PathVariable Integer uID, @PathVariable Integer vID){
        BKCollection collection = new BKCollection();
        collection.setUID(uID);
        collection.setFavVideoID(vID);
        return interactiveVideoService.deleteCollection(collection);
    }
}
