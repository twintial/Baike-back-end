package com.example.baike.service;

import com.example.baike.result.Result;

public interface VideoService {
    Result findURLANDNextVideosByNowVID(Integer vID);
}
