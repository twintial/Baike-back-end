package com.example.baike.service;

import com.example.baike.model.BKSearchUserListViewModel;

import com.github.pagehelper.Page;


public interface SearchUserService {
    BKSearchUserListViewModel selectByName(String SearchName,Integer page);
}
