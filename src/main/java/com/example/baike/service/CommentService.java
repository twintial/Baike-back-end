package com.example.baike.service;

import com.example.baike.model.BKComments;
import com.example.baike.result.Result;

public interface CommentService {
    Result insertComment(BKComments comments);
}
