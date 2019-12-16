package com.example.baike.service.impl;

import com.example.baike.mapper.SearchVideoByAdministrationMapper;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.model.BKSearchVideoListViewModel;
import com.example.baike.service.SearchVideoByAdministrationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchVideoByAdministrationServiceImpl implements SearchVideoByAdministrationService {
    @Autowired
    SearchVideoByAdministrationMapper searchVideoByAdministrationMapper;

    public BKSearchVideoListViewModel selectByName(String SearchName, Integer page,String SearchStyle,String tag){
        PageHelper.startPage(page,9);
        List<BKInteractiveVideo> y;
        Integer state=0;
        if(tag.equals("NORMAL")) state=2;
        switch(SearchStyle) {
            case "Collect":
            y = searchVideoByAdministrationMapper.selectByCollectVolume(SearchName,state);
            break;
            case "playV":
            y = searchVideoByAdministrationMapper.selectByPlayVolume(SearchName,state);
            break;
            default:
            y = searchVideoByAdministrationMapper.selectByTime(SearchName,state);
            break;
        }
        Integer num= Math.toIntExact(((Page) y).getTotal());
        System.out.println(num);
        return new BKSearchVideoListViewModel(y,num);
    }
}
