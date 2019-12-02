package com.example.baike.mapper;

import com.example.baike.model.BKInteractiveVideo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoByOrderMapper {
    List<BKInteractiveVideo> selectByPlayVolume();
    List<BKInteractiveVideo> selectByCollectVolume();
    List<BKInteractiveVideo> selectByPraiseVolume();
    List<BKInteractiveVideo> selectByTime();
}
