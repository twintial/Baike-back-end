package com.example.baike.controller;

import com.example.baike.model.BKVideoUploadViewModel;
import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.InteractiveVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.example.baike.constant.ResourcePath.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class VideoUploadController {
    @Autowired
    InteractiveVideoService interactiveVideoService;
    @PostMapping("/video/upload")
    public ResourceResult videoUpload(@RequestParam("file") MultipartFile file) throws IOException {
        return interactiveVideoService.createTemp(file);
    }

    @PostMapping("/cover/upload")
    public ResourceResult coverUpload(@RequestParam("videoCover") MultipartFile file) throws IOException {
        return interactiveVideoService.createTemp(file);
    }

    @DeleteMapping("/upload/{uuid}/{type}")
    public boolean delete(@PathVariable("uuid") String uuid, @PathVariable("type") String type){
        log.info(baseURL + tempURL + uuid + "." + type);
        return interactiveVideoService.deleteFile(new File(baseURL + tempURL + uuid + "." + type));
    }

    @PostMapping("/video/submit")
    public Result submit(@Valid @RequestBody BKVideoUploadViewModel uploadViewModel , BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()){
            String msg = String.format("上传失败，%s。",
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(msg);
        }
        return interactiveVideoService.uploadInteractiveVideo(uploadViewModel, session);
    }
}
