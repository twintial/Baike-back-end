package com.example.baike.service;

import com.example.baike.model.BKInteractiveVideo;

import java.util.List;

public interface VideoByOrderService {
    List<BKInteractiveVideo> selectByPlayVolume();
    List<BKInteractiveVideo> selectByCollectVolume();
    List<BKInteractiveVideo> selectByPraiseVolume();
    List<BKInteractiveVideo> selectByTime();
}
