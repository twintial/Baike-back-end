package com.example.baike.service;

import com.example.baike.result.ResourceResult;
import com.example.baike.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EditVideoService {
    Result getVideoList(Integer interVID);
    Result getInterVideoStructure(String structure, Integer interVID);
}
