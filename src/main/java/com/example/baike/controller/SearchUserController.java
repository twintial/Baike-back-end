package com.example.baike.controller;

import com.example.baike.model.BKSearchUserListViewModel;
import com.example.baike.service.SearchUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//控制类
@RestController
@RequestMapping("/api")
public class SearchUserController {
    @Autowired
    SearchUserService searchUserService;

    @GetMapping("/SearchUser/{title}/{page}")
    public BKSearchUserListViewModel Search(@PathVariable("title") String SearchName,@PathVariable("page") Integer page){
        return  searchUserService.selectByName(SearchName,page);
    }
    //当搜索名为空时
    @GetMapping("/SearchUser/{page}")
    public BKSearchUserListViewModel Search2(@PathVariable("page") Integer page){
        return  searchUserService.selectByName("",page);
    }
}
