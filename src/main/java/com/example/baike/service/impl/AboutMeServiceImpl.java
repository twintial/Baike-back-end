package com.example.baike.service.impl;

import com.example.baike.mapper.AboutMeMapper;
import com.example.baike.mapper.InteractiveVideoMapper;
import com.example.baike.model.BKHeadInfoViewModel;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;
import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.AboutMeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.example.baike.constant.ResourcePath.baseURL;
import static com.example.baike.constant.ResourcePath.tempURL;

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

    @Override
    public Result getLoginUserInfo(Integer vID, HttpSession session) {
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        BKUserInfo userInfo = aboutMeMapper.selectUserInfoByID(user.getUID());
        Long colNum = aboutMeMapper.isCollect(user.getUID(), vID);
        return ResultFactory.buildSuccessWithMsg(colNum.toString(), userInfo);
    }

    @Override
    public Result setUserIcon(MultipartFile file , Integer UserID , String IconID) throws IOException{
        log.info("play");
        if (UserID == null){
            log.info("no user");
            return ResultFactory.buildFailResult("Please Login First");
        }
        if (!file.isEmpty()){
            if (file.getContentType() != null && file.getOriginalFilename()!= null){
                String fileName = file.getOriginalFilename();
                String type = fileName.substring(fileName.lastIndexOf("."));
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String path = baseURL + "img" + File.separator + "userIcon" + File.separator + UserID + File.separator + uuid + type;
                File dest = new File(path);
                //判断文件父目录是否存在
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                file.transferTo(dest);
                String final_path = UserID + File.separator + uuid + type;
                try {
                    log.info("start");
                    aboutMeMapper.updateUsersIconByID(UserID , final_path);
                    if( IconID != "user_default.jpg"){
                        deleteFile(new File( baseURL + "img" + File.separator + "userIcon" + File.separator + IconID));
                    }
                }catch (Exception e){
                    return ResultFactory.buildFailResult("Unexpected Error");
                }
                return ResultFactory.buildSuccessResult("Upload Icon Success");
            }
        }
        return ResultFactory.buildFailResult("Upload Icon Fail");

    }

    @Override
    public Boolean deleteFile(File file) {
        if (!file.exists()){
            return false;
        }
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f: files){
                deleteFile(f);
            }
        }
        return file.delete();
    }

    @Override
    public Result setUserBackIcon(MultipartFile file , Integer UserID, String IconID) throws IOException{
        if (UserID == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        if (!file.isEmpty()){
            if (file.getContentType() != null && file.getOriginalFilename()!= null){
                String fileName = file.getOriginalFilename();
                String type = fileName.substring(fileName.lastIndexOf("."));
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String path = baseURL + "img" + File.separator + "userIcon" + File.separator + UserID + File.separator + uuid + type;
                File dest = new File(path);
                //判断文件父目录是否存在
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                file.transferTo(dest);
                String final_path = UserID + "/" + uuid + type;
                try {
                    log.info("insert");
                    aboutMeMapper.updateUsersBackIconByID(UserID , final_path);
                    if( IconID != "back_default.jpg"){
                        deleteFile(new File( baseURL + "img" + File.separator + "userIcon" + File.separator + IconID));
                    }
                }catch (Exception e){
                    return ResultFactory.buildFailResult("Unexpected Error");
                }
                return ResultFactory.buildSuccessResult("Upload Icon Success");
            }
        }
        return ResultFactory.buildFailResult("Upload Icon Fail");
    }

    @Override
    public Result getHisVideos(Integer oID , Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<BKInteractiveVideo> videos = aboutMeMapper
                .selectHisVideoByUid(oID);
        PageInfo page = new PageInfo(videos);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), videos);
    }

    @Override
    public Result favHisVideo(Integer vID , HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        try {
            aboutMeMapper.insertFavVideoByID(user.getUID() , vID);
        }catch (Exception e){
            return ResultFactory.buildFailResult("You have subscribed the video already");
        }
        return ResultFactory.buildSuccessResult("Subscribe Success");
    }

    @Override
    public Result getBrowseHistory(Integer pageNum, HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        PageHelper.startPage(pageNum,10);
        List<BKInteractiveVideo> videos = aboutMeMapper
                .selectBrowseHistoryByUid(user.getUID());
        PageInfo page = new PageInfo(videos);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), videos);
    }

    @Override
    public Result deleteBrowseHistory(Integer vID, HttpSession session){
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login First");
        }
        try {
            aboutMeMapper.deleteBrowseHistoryByID(user.getUID() , vID);
        }catch (Exception e){
            return ResultFactory.buildFailResult(e.toString());
        }
        return ResultFactory.buildSuccessResult("success");
    }
}
