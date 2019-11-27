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

        JSONObject jsonObject = new JSONObject(structure);
        String startVideoName = jsonObject.getString("video");
        int startVideoID = returnVideoID(startVideoName, interVID);

        System.out.println(startVideoName);
        System.out.println(startVideoID);
        interactiveVideoMapper.updateInterVideoStartVideo(interVID, startVideoID);

        getRelationship(jsonObject, interVID);
    }

    public void getRelationship(JSONObject jsonObject, Integer interVID){

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

        List<BKVideo> videos = interactiveVideoMapper.selectVideoByInterVID(interVID);
        for (int i = 0; i < videos.size(); i++){
            if (videos.get(i).getTitle().equals(videoName)){
                return videos.get(i).getVideoID();
            }
        }
        return -1;
    }
}
