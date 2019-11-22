package com.example.baike.service;

import com.example.baike.model.BKInteractiveVideo;

import java.util.List;

public interface SearchVideoService {
    List<BKInteractiveVideo> selectByName(String SearchName);
}
