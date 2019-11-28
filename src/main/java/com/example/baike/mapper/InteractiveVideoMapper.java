package com.example.baike.mapper;

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKNextVideo;
import com.example.baike.model.BKVideo;
import com.example.baike.model.BKVideoPlayVideoModel;
import com.example.baike.model.BKVideoUploadViewModel;
import com.example.baike.state.VideoState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InteractiveVideoMapper {
    Long insertInteractiveVideo(BKVideoUploadViewModel uploadViewModel);
    Long insertVideo(List<BKVideo> videos);
    Long deleteInteractiveVideoByID(@Param("vID") Integer vID);
    Long updateInterVideoStartVideo
            (@Param("interVideoID") Integer interVideoID, @Param("initVideoID") Integer initVideoID);
    Long insertNextVideo(BKNextVideo bkNextVideo);
    List<BKInteractiveVideo> selectInterVideosByUserIf(@Param("uID") Integer uID, @Param("state")VideoState state);
    // 通过interVideoID找到播放这个视频的页面所需要的大部分信息
    BKVideoPlayVideoModel findVideoPlayPageInfo(@Param("interVideoID") Integer interVideoID);
    List<BKVideo> selectVideoByInterVID(@Param("interVideoID") Integer interVideoID);
    // 根据一个视频id找到其下一个视频
    List<BKNextVideo> selectNextVideoByNowVID(@Param("videoID") Integer videoID);
    // 根据一个视频id找到其URL
    BKVideo selectVideoByVID(@Param("id") Integer videoID);
}
