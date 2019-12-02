package com.example.baike.service.impl;

import com.example.baike.mapper.SearchUserMapper;
import com.example.baike.model.BKSearchUser;
import com.example.baike.model.BKSearchUserListViewModel;
import com.example.baike.service.SearchUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserServiceImpl implements SearchUserService {

    @Autowired
    SearchUserMapper searchUserMapper;

    @Override
    public BKSearchUserListViewModel selectByName(String SearchName, Integer page) {
        PageHelper.startPage(page,4);
        List<BKSearchUser> y=searchUserMapper.selectByName(SearchName);
        Integer num= Math.toIntExact(((Page) y).getTotal());
        System.out.println(num);
        return new BKSearchUserListViewModel(y,num);
    }
}
