package com.example.baike.mapper;

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.InterVideoViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoByOrderMapper {
    List<InterVideoViewModel> selectByPlayVolume();
    List<InterVideoViewModel> selectByCollectVolume();
    List<InterVideoViewModel> selectByPraiseVolume();
    List<InterVideoViewModel> selectByTime();
}
