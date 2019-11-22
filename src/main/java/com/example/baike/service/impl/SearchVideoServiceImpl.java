package com.example.baike.service.impl;

import com.example.baike.mapper.LoginMapper;
import com.example.baike.mapper.SearchResultMapper;
import com.example.baike.model.BKInteractiveVideo;
import com.example.baike.service.SearchVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchVideoServiceImpl implements SearchVideoService {

    @Autowired
    SearchResultMapper searchResultMapper;

    public List<BKInteractiveVideo> selectByName(String SearchName){
        return searchResultMapper.selectByName(SearchName);
    }
}
