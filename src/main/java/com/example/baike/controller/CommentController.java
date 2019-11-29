package com.example.baike.controller;

import com.example.baike.model.BKComments;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;
    @PostMapping("/send/comment")
    public Result sendComment(@Valid @RequestBody BKComments comments, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String msg = String.format("%s",
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(msg);
        }
        comments.setSendTime(new Date());
        return commentService.insertComment(comments);
    }
}
