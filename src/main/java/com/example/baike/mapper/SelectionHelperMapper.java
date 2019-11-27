package com.example.baike.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SelectionHelperMapper {
    Integer selectByNickName(@Param("nickName") String nickName);
    Integer selectByAccount(@Param("account") String account);
}
