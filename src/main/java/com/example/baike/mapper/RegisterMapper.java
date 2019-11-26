package com.example.baike.mapper;

import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegisterMapper {
    Long userRegister(BKUser user);
    Long addInfo(BKUserInfo info);
    // 删除用户
    Long rollBackUser(BKUser user);
}
