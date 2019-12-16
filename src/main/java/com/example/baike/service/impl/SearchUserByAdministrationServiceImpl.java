package com.example.baike.service.impl;

import com.example.baike.mapper.SearchUserByAdministrationMapper;
import com.example.baike.model.BKSearchUserByAdministrationViewModel;
import com.example.baike.model.BKUserState;
import com.example.baike.service.SearchUserByAdministrationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserByAdministrationServiceImpl implements SearchUserByAdministrationService {
    @Autowired
    SearchUserByAdministrationMapper searchUserByAdministrationMapper;

    @Override
    public BKSearchUserByAdministrationViewModel selectByName(String SearchName, Integer page,String SearchStyle,String tag) {
        List<BKUserState> y;
        Integer state=0;
        if(tag.equals("NORMAL")) state=1;
        PageHelper.startPage(page,9);
        switch(SearchStyle) {
            case "name":
            y = searchUserByAdministrationMapper.selectByName(SearchName,state);
            break;
            default:
                y=searchUserByAdministrationMapper.selectByTime(SearchName,state);
                break;
        }
        Integer num= Math.toIntExact(((Page) y).getTotal());
        return new BKSearchUserByAdministrationViewModel(y,num);
    }
}
