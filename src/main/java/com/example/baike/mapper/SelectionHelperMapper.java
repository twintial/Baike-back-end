package com.example.baike.mapper;

import com.example.baike.model.BKUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SelectionHelperMapper {
    Integer selectByNickName(@Param("nickName") String nickName);
    Integer selectByAccount(@Param("account") String account);
}