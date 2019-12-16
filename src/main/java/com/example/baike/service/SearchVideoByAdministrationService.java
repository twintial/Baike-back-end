package com.example.baike.service;

import com.example.baike.model.BKSearchVideoListViewModel;

public interface SearchVideoByAdministrationService {
    BKSearchVideoListViewModel selectByName(String SearchName, Integer page,String SearchStyle,String tag);
}
