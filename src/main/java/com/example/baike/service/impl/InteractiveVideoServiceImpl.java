package com.example.baike.service.impl;

import com.example.baike.mapper.InteractiveVideoMapper;
import com.example.baike.model.*;
import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.InteractiveVideoService;
import com.example.baike.state.VideoState;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.example.baike.state.VideoState.*;
import static com.example.baike.constant.ResourcePath.*;

@Slf4j
@Service
public class InteractiveVideoServiceImpl implements InteractiveVideoService {
    @Autowired
    InteractiveVideoMapper interactiveVideoMapper;

    @Override
    public ResourceResult createTemp(MultipartFile file) throws IOException {
        ResourceResult result = new ResourceResult();
        if (!file.isEmpty()){
            if (file.getContentType() != null && file.getOriginalFilename()!= null){
                String fileName = file.getOriginalFilename();
                String type = fileName.substring(fileName.lastIndexOf("."));
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String path = baseURL + tempURL + uuid + type;
                File dest = new File(path);
                //判断文件父目录是否存在
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                file.transferTo(dest);
                result.setSuccess(true);
                result.setUuid(uuid);
                result.setType(type.replace(".", ""));
                return result;
            }
        }
        result.setSuccess(false);
        result.setError("文件不存在");
        return result;
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
    public Result uploadInteractiveVideo(BKVideoUploadViewModel uploadViewModel, HttpSession session) {
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("Please Login");
        }
        File file;
        // 插入互动视频
        uploadViewModel.setUID(user.getUID());
        uploadViewModel.setState(VideoState.EDITABLE);
        uploadViewModel.setUploadTime(new Date());
        uploadViewModel.setIcon(uploadViewModel.getCoverUUID());
        try {
            interactiveVideoMapper.insertInteractiveVideo(uploadViewModel);
        }catch (Exception e){
            return ResultFactory.buildFailResult("出现未知错误，上传失败");
        }
        // 移动图片
        File coverDir = new File(baseURL + "img" + File.separator + "videoCover" + File.separator
                + uploadViewModel.getInterVideoID() + File.separator);
        coverDir.mkdir();
        file = new File(baseURL + tempURL + uploadViewModel.getCoverUUID());
        if (!file.isFile()){
            return ResultFactory.buildFailResult("不存在此封面");
        }
        file.renameTo(new File(coverDir.getPath() + File.separator + uploadViewModel.getCoverUUID()));
        // 移动视频
        File dir = new File(baseURL + "video" + File.separator +
                uploadViewModel.getInterVideoID() + File.separator);
        dir.mkdir();
        for (int i = 0; i < uploadViewModel.getVideoFilesUUID().size(); i++) {
            String fileName = uploadViewModel.getVideoFilesUUID().get(i);
            file = new File(baseURL + tempURL + fileName);
            if (!file.isFile()){
                return ResultFactory.buildFailResult("不存在此视频文件");
            }
            file.renameTo(new File(dir.getPath() + File.separator + fileName));
        }
        // 插入单个视频
        List<BKVideo> videos = new ArrayList<>();
        for (int i = 0; i < uploadViewModel.getVideoFilesUUID().size(); i++) {
            BKVideo video = new BKVideo();
            video.setInterVideoID(uploadViewModel.getInterVideoID());
            video.setTitle("P" + (i+1) + "_" + uploadViewModel.getVideoNames().get(i));
            video.setVideoURL("video" + File.separator + uploadViewModel.getInterVideoID() +
                    File.separator + uploadViewModel.getVideoFilesUUID().get(i));
            videos.add(video);
        }
        try {
            interactiveVideoMapper.insertVideo(videos);
        }catch (Exception e){
            return ResultFactory.buildFailResult("出现未知错误，上传失败");
        }
        return ResultFactory.buildSuccessResult("上传成功");
    }

    @Override
    public Result getInteractiveVideoPage(String state ,Integer pageNum, HttpSession session) {
        BKUser user = (BKUser) session.getAttribute("user");
        if (user == null){
            return ResultFactory.buildFailResult("未登陆");
        }
        VideoState videoState;
        if (state.equals("publish")){
            videoState = PUBLISH;
        }else {
            videoState = EDITABLE;
        }
        PageHelper.startPage(pageNum,10);
        List<BKInteractiveVideo> videos = interactiveVideoMapper
                .selectInterVideosByUserIf(user.getUID(), videoState);
        PageInfo page = new PageInfo(videos);
        return ResultFactory.buildSuccessWithMsg(String.valueOf(page.getPages()), videos);
    }

    @Override
    public Result deleteInteractiveVideoByID(Integer vID) {
        interactiveVideoMapper.deleteInteractiveVideoByID(vID);
        return ResultFactory.buildSuccessResult("success");
    }

    @Override
    public Result findInterVideoInfoByVID(Integer interVID) {
        BKVideoPlayVideoModel videoPlayVideoModel = interactiveVideoMapper.findVideoPlayPageInfo(interVID);

        return ResultFactory.buildSuccessResult(videoPlayVideoModel);
    }
}
