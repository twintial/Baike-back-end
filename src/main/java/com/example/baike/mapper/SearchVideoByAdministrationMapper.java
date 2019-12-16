package com.example.baike.mapper;

import com.example.baike.model.BKInteractiveVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SearchVideoByAdministrationMapper {
    List<BKInteractiveVideo> selectByTime(@Param("SearchName") String SearchName,@Param("state") Integer state);
    List<BKInteractiveVideo> selectByPlayVolume(@Param("SearchName") String SearchName,@Param("state") Integer state);
    List<BKInteractiveVideo> selectByCollectVolume(@Param("SearchName") String SearchName,@Param("state") Integer state);
}
