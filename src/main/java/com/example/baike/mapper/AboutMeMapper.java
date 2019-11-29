package com.example.baike.mapper;

import com.example.baike.model.*;
import com.example.baike.state.VideoState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AboutMeMapper {
    BKHeadInfoViewModel selectHeadInfoByUid(@Param("uID") Integer uID);

    List<BKInteractiveVideo> selectFavVideoByUid(@Param("uID") Integer uID);

    Long deleteFavVideoByID(@Param("vID") Integer vID, @Param("favID") Integer favID);

    List<BKUserInfo> selectUserFollowersByUid(@Param("uID") Integer uID);

    List<BKUserInfo> selectUsersFollowByUid(@Param("uID") Integer uID);

    Long updateUserInforByID(@Param("vID") Integer vID, @Param("newNickName") String newNickName, @Param("newIntro") String newIntro);

    Long deleteUsersFollowByID(@Param("vID") Integer vID, @Param("followID") Integer followID);

    Long insertUsersFollowByID(@Param("vID") Integer vID, @Param("followID") Integer followID);

    Long updateUsersIconByID(@Param("vID") Integer vID, @Param("iconID") String iconID);

    Long updateUsersBackIconByID(@Param("vID") Integer vID, @Param("iconID") String iconID);

    List<BKInteractiveVideo> selectHisVideoByUid(@Param("uID") Integer uID);

    Long insertFavVideoByID(@Param("vID") Integer vID, @Param("videoID") Integer videoID);
}
