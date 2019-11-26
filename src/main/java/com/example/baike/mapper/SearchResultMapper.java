package com.example.baike.mapper;

import com.example.baike.model.BKInteractiveVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
//@param是传入xml中的参数
public interface SearchResultMapper {
    List<BKInteractiveVideo> selectByName(@Param("SearchName") String SearchName,@Param("tag") String tag);
}
