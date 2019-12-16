package com.example.baike.mapper;

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.InterVideoViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SearchVideoByAdministrationMapper {
    List<InterVideoViewModel> selectByTime(@Param("SearchName") String SearchName, @Param("state") Integer state);
    List<InterVideoViewModel> selectByPlayVolume(@Param("SearchName") String SearchName,@Param("state") Integer state);
    List<InterVideoViewModel> selectByCollectVolume(@Param("SearchName") String SearchName,@Param("state") Integer state);
}
