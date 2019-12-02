package com.example.baike.service.impl;


import com.example.baike.mapper.InteractiveVideoMapper;
import com.example.baike.model.BKNextVideo;
import com.example.baike.model.BKVideo;
import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.EditVideoService;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class EditVideoServiceImpl implements EditVideoService {
    @Autowired
    InteractiveVideoMapper interactiveVideoMapper;

    @Override
    public Result getVideoList(Integer InterVID){

        //获取用户之前上传的视频列表，供用户编辑时选择
        List<BKVideo> videos = interactiveVideoMapper.selectVideoByInterVID(InterVID);
        if (videos == null){
            return ResultFactory.buildFailResult("Error!");
        }
        else {
            return ResultFactory.buildSuccessResult(videos);
        }
    }

    @Override
    public Result getInterVideoStructure(String structure, Integer interVID){

        solveStructure(structure, interVID);
        ResourceResult result = new ResourceResult();
        return ResultFactory.buildSuccessResult("Commit Success!");
    }

    public void solveStructure(String structure, Integer interVID){
        //获取JSON字符串
        JSONObject jsonObject = new JSONObject(structure);
        //获取起始视频
        String startVideoName = jsonObject.getString("video");
        //获取起始视频ID
        int startVideoID = returnVideoID(startVideoName, interVID);

//        System.out.println(startVideoName);
//        System.out.println(startVideoID);
        //更新表数据
        interactiveVideoMapper.updateInterVideoStartVideo(interVID, startVideoID);
        //检测视频是否已被编辑，如果已被编辑，先删除之前的数据
        deleteStructure(interVID);
        //向数据库插入视频结构信息
        getRelationship(jsonObject, interVID);
    }

    public void deleteStructure(Integer interVID){

        //获取interVideo的状态信息，为1则退出。为2则删除数据
        int state = interactiveVideoMapper.selectInterVideoStateByID(interVID);
        if (state == 1){
            return;
        }
        else {
            int initVideoID = interactiveVideoMapper.selectInitVideoIDByID(interVID);
            List<BKNextVideo> nextVideos = interactiveVideoMapper.selectNextVideoByVideoID(initVideoID);
            if (nextVideos.size() == 0){
                return;
            }
            for (int i = 0; i < nextVideos.size(); i++){
                int nextVideoID = nextVideos.get(i).getNextVideoID();
                deleteRelationship(nextVideoID);
            }
            interactiveVideoMapper.deleteNextVideoByID(initVideoID);
            return;
        }
    }

    public void deleteRelationship(Integer nextVideoID){
        int nowVideoID = nextVideoID;
        List<BKNextVideo> nextVideos = interactiveVideoMapper.selectNextVideoByVideoID(nowVideoID);
        if (nextVideos.size() == 0){
            return;
        }
        else {
            for (int i = 0; i < nextVideos.size(); i++){
                int next = nextVideos.get(i).getNextVideoID();
                deleteRelationship(next);
            }
            interactiveVideoMapper.deleteNextVideoByID(nowVideoID);
            return;
        }
    }

    public void getRelationship(JSONObject jsonObject, Integer interVID){

        //递归遍历JSON树，将分支选项和视频插入数据库
        if (!jsonObject.isNull("children")){
            String nowVideoName = jsonObject.getString("video");
            JSONArray jsonArray = jsonObject.getJSONArray("children");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject childJsonObject = jsonArray.getJSONObject(i);
                String childVideoName = childJsonObject.getString("video");
                String childVideoPlot = childJsonObject.getString("plot");
                int childVideoID = returnVideoID(childVideoName, interVID);
                int nowVideoID = returnVideoID(nowVideoName, interVID);

                BKNextVideo bkNextVideo = new BKNextVideo();
                bkNextVideo.setVideoID(nowVideoID);
                bkNextVideo.setNextVideoID(childVideoID);
                bkNextVideo.setChoice(childVideoPlot);
                interactiveVideoMapper.insertNextVideo(bkNextVideo);

                getRelationship(childJsonObject, interVID);
            }
        }
        else {
            return;
        }
    }

    public int returnVideoID(String videoName, Integer interVID){

        //返回JSON中的视频ID信息
        List<BKVideo> videos = interactiveVideoMapper.selectVideoByInterVID(interVID);
        for (int i = 0; i < videos.size(); i++){
            if (videos.get(i).getTitle().equals(videoName)){
                return videos.get(i).getVideoID();
            }
        }
        return -1;
    }
}
