package com.example.baike.service.impl;

import com.example.baike.mapper.SearchResultMapper;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKSearchVideoListViewModel;
import com.example.baike.model.InterVideoViewModel;
import com.example.baike.service.SearchVideoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchVideoServiceImpl implements SearchVideoService {

    @Autowired
    SearchResultMapper searchResultMapper;

    public BKSearchVideoListViewModel selectByName(String SearchName, String tag, Integer page){
        PageHelper.startPage(page,9);
        List<InterVideoViewModel> y=searchResultMapper.selectByName(SearchName,tag);
        Integer num= Math.toIntExact(((Page) y).getTotal());
        System.out.println(num);
        return new BKSearchVideoListViewModel(y,num);
    }


    public List<InterVideoViewModel> category(String tag, int pageSize){
        PageHelper.startPage(1,pageSize);
        return searchResultMapper.selectByName(tag,tag);
    }

}
