package com.example.baike.service;

import com.example.baike.model.*;
import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public interface InteractiveVideoService {
    ResourceResult createTemp(MultipartFile file) throws IOException;
    Boolean deleteFile(File file);
    Result uploadInteractiveVideo(BKVideoUploadViewModel uploadViewModel, HttpSession session);
    Result getInteractiveVideoPage(String state ,Integer pageNum ,HttpSession session);
    Result deleteInteractiveVideoByID(Integer vID);
    // 播放界面寻找全部信息
    Result findInterVideoInfoByVID(Integer interVID);
    // 插入历史记录
    Result insertBrowseHistory(BKBrowseHistory bkBrowseHistory);
    // 插入删除收藏夹
    Result insertCollection(BKCollection collection);
    Result deleteCollection(BKCollection collection);
}
