package com.example.baike.service.impl;

import com.example.baike.mapper.SearchUserMapper;
import com.example.baike.model.BKSearchUser;
import com.example.baike.model.BKSearchUserListViewModel;
import com.example.baike.service.SearchUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchUserServiceImpl implements SearchUserService {

    @Autowired
    SearchUserMapper searchUserMapper;

    @Autowired
    SearchUserMapper searchUserMapper1;

    @Autowired
    SearchUserMapper searchUserMapper2;

    @Override
    public BKSearchUserListViewModel selectByName(String SearchName, Integer page) {
        PageHelper.startPage(page,4);
        List<BKSearchUser> y=searchUserMapper.selectByName(SearchName);
        Integer num= Math.toIntExact(((Page) y).getTotal());
        List<Integer> fn=new ArrayList<Integer>();
        List<Integer> VN=new ArrayList<Integer>();
        for(BKSearchUser i:y){
            fn.add(searchUserMapper1.followByID(i.getUID()));
            VN.add(searchUserMapper2.videoByID(i.getUID()));
        }
        System.out.println(num);
        return new BKSearchUserListViewModel(y,num,fn,VN);
    }
}
