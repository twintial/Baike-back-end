package com.example.baike.service;

import com.example.baike.model.BKHeadInfoViewModel;
import com.example.baike.result.Result;

import javax.servlet.http.HttpSession;

public interface AboutMeService {
    Result getUserFollowerNum(HttpSession session);

    Result getUserFavVideo(Integer pageNum, HttpSession session);

    Result deleteUserFavVideo(Integer vID, HttpSession session);

    Result getUserFollowers(Integer pageNum, HttpSession session);

    Result getUsersFollow(Integer pageNum, HttpSession session);

    Result updateUsersInfo(String newNickName,String newIntro, HttpSession session);

    Result deleteUsersFollow(Integer vID, HttpSession session);

    Result getOUserFollowerNum(Integer oID);

    Result getOUserFavVideo(Integer oID , Integer pageNum);

    Result getOUserFollowers(Integer oID , Integer pageNum);

    Result getOUsersFollow(Integer oID , Integer pageNum);

    Result subscribeFollower(Integer oID , HttpSession session);
}
