package com.example.baike.mapper;

import com.example.baike.model.*;
import com.example.baike.constant.state.VideoState;
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
    Long deleteNextVideoByID(@Param("videoID") Integer videoID);

    List<BKInteractiveVideo> selectInterVideosByUserIf(@Param("uID") Integer uID, @Param("state")VideoState state);
    // 通过interVideoID找到播放这个视频的页面所需要的大部分信息
    BKVideoPlayVideoModel findVideoPlayPageInfo(@Param("interVideoID") Integer interVideoID);
    List<BKVideo> selectVideoByInterVID(@Param("interVideoID") Integer interVideoID);
    // 根据一个视频id找到其下一个视频
    List<BKNextVideo> selectNextVideoByNowVID(@Param("videoID") Integer videoID);
    // 根据一个视频id找到其URL
    BKVideo selectVideoByVID(@Param("id") Integer videoID);
    // 历史记录有关
    Long insertBrowseHistory(BKBrowseHistory bkBrowseHistory);
    Long updateBrowseHistory(BKBrowseHistory bkBrowseHistory);
    // 收藏视频和取消收藏
    Long insertCollection(BKCollection bkCollection);
    Long deleteCollection(BKCollection bkCollection);
    Integer selectInterVideoStateByID(@Param("interVideoID") Integer interVideoID);
    Integer selectInitVideoIDByID(@Param("interVideoID") Integer interVideoID);
    List<BKNextVideo> selectNextVideoByVideoID(@Param("videoID") Integer videoID);
}
