package com.example.baike.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ChangeStateMapper {
   Long changeUser(@Param("uID") Integer uID);
    Long changeVideo(@Param("interVideoID") Integer uID);
}
