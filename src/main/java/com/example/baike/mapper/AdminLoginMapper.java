package com.example.baike.mapper;

import com.example.baike.model.BKAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper @Repository
public interface AdminLoginMapper {
    BKAdmin Detection(@Param("account") String account, @Param("password")String password);
}
