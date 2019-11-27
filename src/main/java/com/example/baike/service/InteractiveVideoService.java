package com.example.baike.service;

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKVideo;
import com.example.baike.model.BKVideoUploadViewModel;
import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import com.example.baike.state.VideoState;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface InteractiveVideoService {
    ResourceResult createTemp(MultipartFile file) throws IOException;
    Boolean deleteFile(File file);
    Result uploadInteractiveVideo(BKVideoUploadViewModel uploadViewModel, HttpSession session);
    Result getInteractiveVideoPage(String state ,Integer pageNum ,HttpSession session);
    Result deleteInteractiveVideoByID(Integer vID);
    Result findInterVideoInfoByVID(Integer interVID);
}
