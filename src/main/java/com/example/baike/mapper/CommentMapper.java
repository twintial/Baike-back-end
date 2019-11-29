package com.example.baike.mapper;

import com.example.baike.model.BKComments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    Long insertComment(BKComments comments);
}
