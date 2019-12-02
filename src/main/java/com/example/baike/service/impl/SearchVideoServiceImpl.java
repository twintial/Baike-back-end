package com.example.baike.service.impl;

import com.example.baike.mapper.LoginMapper;
import com.example.baike.mapper.SearchResultMapper;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKSearchVideoListViewModel;
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
        List<BKInteractiveVideo> y=searchResultMapper.selectByName(SearchName,tag);
        Integer num= Math.toIntExact(((Page) y).getTotal());
        System.out.println(num);
        return new BKSearchVideoListViewModel(y,num);
    }


    public List<BKInteractiveVideo> category(int tag){
        if(tag==1){return searchResultMapper.selectByName("1","1");}
        else if(tag==2){return searchResultMapper.selectByName("2","2");}
        else if(tag==3){return searchResultMapper.selectByName("3","3");}
        else {return searchResultMapper.selectByName("4","4");}
    }

//    @Override
//    public Page<BKInteractiveVideo> pageResult(String SearchName) {
//        return (Page<BKInteractiveVideo>)searchResultMapper.selectByName(SearchName);
//    }
}
