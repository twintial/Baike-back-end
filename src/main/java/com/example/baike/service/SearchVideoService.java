package com.example.baike.service;

import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKSearchVideoListViewModel;
import com.github.pagehelper.Page;

import java.util.List;

public interface SearchVideoService {
    BKSearchVideoListViewModel selectByName(String SearchName, String tag, Integer page);
    List<BKInteractiveVideo> category(int tag);
}
