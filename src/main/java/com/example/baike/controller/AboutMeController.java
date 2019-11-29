package com.example.baike.controller;


import com.example.baike.model.BKLoginInfo;
import com.example.baike.model.BKUserInfo;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.AboutMeService;
import com.example.baike.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.Objects;

import static com.example.baike.constant.ResourcePath.coverImgDirURL;
import static com.example.baike.constant.ResourcePath.videoDirURL;

@Slf4j
@RestController
@RequestMapping("/api")
public class AboutMeController {
    @Autowired
    AboutMeService aboutMeService;

    @PostMapping("/aboutMe")
    public Result getUserInfomation(HttpSession session){
        return aboutMeService.getUserFollowerNum(session);
    }

    @GetMapping("/getLoginUserInfo")
    public Result getLoginUserInfo(HttpSession session){
        return aboutMeService.getLoginUserInfo(session);
    }

    @GetMapping("/aboutMe/favVideo/{pageNum}")
    public Result getFavVideoByPage(@PathVariable Integer pageNum, HttpSession session){
        return aboutMeService.getUserFavVideo(pageNum ,session);
    }

    @DeleteMapping("/aboutMe/favVideo/{interVideoID}")
    public Result deleteFavVideo(@PathVariable Integer interVideoID, HttpSession session){
        return aboutMeService.deleteUserFavVideo(interVideoID , session);
    }

    @GetMapping("/aboutMe/userFollowers/{pageNum}")
    public Result getUserFollowersByPage(@PathVariable Integer pageNum, HttpSession session){
        return aboutMeService.getUserFollowers(pageNum , session);
    }

    @GetMapping("/aboutMe/usersFollow/{pageNum}")
    public Result getUsersFollowByPage(@PathVariable Integer pageNum, HttpSession session){
        return aboutMeService.getUsersFollow(pageNum , session);
    }

    @PostMapping("/aboutMe/setting")
    public Result updateUserInfo(@RequestBody BKUserInfo userInfo, HttpSession session){
        return aboutMeService.updateUsersInfo(userInfo.getNickName(),userInfo.getIntroduction(),session);
    }

    @DeleteMapping("/aboutMe/usersFollow/{unFollowID}")
    public Result deleteUsersFollow(@PathVariable Integer unFollowID, HttpSession session){
        return aboutMeService.deleteUsersFollow(unFollowID , session);
    }

    @GetMapping("/aboutHis/{oID}")
    public Result getOUserInfomation(@PathVariable Integer oID){
        return aboutMeService.getOUserFollowerNum(oID);
    }

    @GetMapping("/aboutHis/favVideo/{oID}/{pageNum}")
    public Result getOUserFavVideoByPage(@PathVariable Integer oID , @PathVariable Integer pageNum){
        return aboutMeService.getOUserFavVideo(oID , pageNum);
    }

    @GetMapping("/aboutHis/userFollowers/{oID}/{pageNum}")
    public Result getOUserFollowersByPage(@PathVariable Integer oID , @PathVariable Integer pageNum){
        return aboutMeService.getOUserFollowers(oID , pageNum);
    }

    @GetMapping("/aboutHis/usersFollow/{oID}/{pageNum}")
    public Result getOUsersFollowByPage(@PathVariable Integer oID , @PathVariable Integer pageNum){
        return aboutMeService.getOUsersFollow(oID , pageNum);
    }

    @GetMapping("/aboutHis/subscribe/{oID}")
    public Result subscribeFollowerByID(@PathVariable Integer oID , HttpSession session){
        return aboutMeService.subscribeFollower(oID , session);
    }

}
