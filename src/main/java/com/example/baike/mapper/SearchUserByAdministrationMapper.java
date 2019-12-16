package com.example.baike.mapper;

import com.example.baike.model.BKUserState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SearchUserByAdministrationMapper {
    List<BKUserState> selectByName(@Param("SearchName") String SearchName,@Param("state") Integer state);
    List<BKUserState> selectByTime(@Param("SearchName") String SearchName,@Param("state") Integer state);
}
