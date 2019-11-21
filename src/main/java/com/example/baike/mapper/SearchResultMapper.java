package com.example.baike.mapper;

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKUserSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SearchResultMapper {
    BKInteractiveVideo selectByName(@Param("SearchName") String SearchName);
}
