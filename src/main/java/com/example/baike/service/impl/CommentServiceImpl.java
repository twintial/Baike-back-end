package com.example.baike.service.impl;

import com.example.baike.mapper.CommentMapper;
import com.example.baike.model.BKComments;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Override
    public Result insertComment(BKComments comments) {
        Long num = commentMapper.insertComment(comments);
        if (num == 1) {
            return ResultFactory.buildSuccessWithMsg("send successfully", comments);
        }
        return ResultFactory.buildFailResult("fail to send");
    }
}
