package com.example.baike.mapper;

import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;
import com.example.baike.state.UserState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    BKUser selectByAccount(@Param("account") String account);
    UserState selectStateByUID(@Param("uID") Integer uID);
}
