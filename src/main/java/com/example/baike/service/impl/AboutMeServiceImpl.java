package com.example.baike.service.impl;

import com.example.baike.mapper.AboutMeMapper;
import com.example.baike.mapper.InteractiveVideoMapper;
import com.example.baike.model.BKHeadInfoViewModel;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.AboutMeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Service
public class AboutMeServiceImpl implements AboutMeService {
    @Autowired
    AboutMeMapper aboutMeMapper;

    @Override
    public Result getUserFollowerNum(HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        BKHeadInfoViewModel bkHeadInfoViewModel;
        try {
            bkHeadInfoViewModel = aboutMeMapper.selectHeadInfoByUid(user.getUID());
        }catch (Exception e){
            return ResultFactory.buildFailResult(e.toString());
        }
        return ResultFactory.buildSuccessResult(bkHeadInfoViewModel);
    }

    @Override
    public Result getUserFavVideo(Integer pageNum, HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        PageHelper.startPage(pageNum,10);
        List<BKInteractiveVideo> videos = aboutMeMapper
                .selectFavVideoByUid(user.getUID());
        PageInfo page = new PageInfo(videos);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), videos);
    }

    @Override
    public Result deleteUserFavVideo(Integer vID, HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        try {
            aboutMeMapper.deleteFavVideoByID(user.getUID() , vID);
        }catch (Exception e){
            return ResultFactory.buildFailResult(e.toString());
        }
        return ResultFactory.buildSuccessResult("success");
    }

    @Override
    public Result getUserFollowers(Integer pageNum, HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("未登陆");
        }
        PageHelper.startPage(pageNum,10);
        List<BKUserInfo> followers = aboutMeMapper
                .selectUserFollowersByUid(user.getUID());
        PageInfo page = new PageInfo(followers);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), followers);
    }

    @Override
    public Result getUsersFollow(Integer pageNum, HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        PageHelper.startPage(pageNum,10);
        List<BKUserInfo> followers = aboutMeMapper
                .selectUsersFollowByUid(user.getUID());
        PageInfo page = new PageInfo(followers);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), followers);
    }

    @Override
    public Result updateUsersInfo(String newNickName,String newIntro, HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        try {
            aboutMeMapper.updateUserInforByID(user.getUID() , newNickName , newIntro);
        }catch (Exception e){
            return ResultFactory.buildFailResult("This name has existed already");
        }
        return ResultFactory.buildSuccessResult("Edit Success");

    }

    @Override
    public Result deleteUsersFollow(Integer vID, HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        try {
            aboutMeMapper.deleteUsersFollowByID(user.getUID() , vID);
        }catch (Exception e){
            return ResultFactory.buildFailResult(e.toString());
        }
        return ResultFactory.buildSuccessResult("success");
    }

    @Override
    public Result getOUserFollowerNum(Integer oID){
        BKHeadInfoViewModel bkHeadInfoViewModel;
        try {
            bkHeadInfoViewModel = aboutMeMapper.selectHeadInfoByUid(oID);
        }catch (Exception e){
            return ResultFactory.buildFailResult(e.toString());
        }
        return ResultFactory.buildSuccessResult(bkHeadInfoViewModel);
    }

    @Override
    public Result getOUserFavVideo(Integer oID , Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<BKInteractiveVideo> videos = aboutMeMapper
                .selectFavVideoByUid(oID);
        PageInfo page = new PageInfo(videos);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), videos);
    }

    @Override
    public Result getOUserFollowers(Integer oID , Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<BKUserInfo> followers = aboutMeMapper
                .selectUserFollowersByUid(oID);
        PageInfo page = new PageInfo(followers);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), followers);
    }

    @Override
    public Result getOUsersFollow(Integer oID , Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<BKUserInfo> followers = aboutMeMapper
                .selectUsersFollowByUid(oID);
        PageInfo page = new PageInfo(followers);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), followers);
    }

    @Override
    public Result subscribeFollower(Integer oID , HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        if(oID.equals(user.getUID())){
            return ResultFactory.buildFailResult("You can not subscribed yourself");
        }
        try {
            aboutMeMapper.insertUsersFollowByID(user.getUID() , oID);
        }catch (Exception e){
            return ResultFactory.buildFailResult("You have subscribed him already");
        }
        return ResultFactory.buildSuccessResult("Subscribe Success");
    }
}
