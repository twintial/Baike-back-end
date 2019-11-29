package com.example.baike.service;

import com.example.baike.model.BKHeadInfoViewModel;
import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

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

    Result setUserIcon(MultipartFile file , Integer UserID, String IconID) throws IOException;

    Boolean deleteFile(File file);

    Result setUserBackIcon(MultipartFile file , Integer UserID, String IconID) throws IOException;

    Result getHisVideos(Integer oID , Integer pageNum);

    Result favHisVideo(Integer vID , HttpSession session);
}
