package com.example.baike.service;

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.InterVideoViewModel;

import java.util.List;

public interface VideoByOrderService {
    List<InterVideoViewModel> selectByPlayVolume();
    List<InterVideoViewModel> selectByCollectVolume();
    List<InterVideoViewModel> selectByPraiseVolume();
    List<InterVideoViewModel> selectByTime();
}
