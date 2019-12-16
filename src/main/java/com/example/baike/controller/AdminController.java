package com.example.baike.controller;
import com.example.baike.model.BKAdmin;
import com.example.baike.model.BKSearchUserByAdministrationViewModel;
import com.example.baike.model.BKSearchVideoListViewModel;
import com.example.baike.service.AdminDetection;
import com.example.baike.service.ChangeStateService;
import com.example.baike.service.SearchUserByAdministrationService;
import com.example.baike.service.SearchVideoByAdministrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
//控制类
@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    SearchVideoByAdministrationService searchVideoByAdministrationService;

    @Autowired
    SearchUserByAdministrationService searchUserByAdministrationService;

    @Autowired
    ChangeStateService changeStateService;

    @Autowired
    AdminDetection adminDetection;

    @GetMapping("/SearchVideoByAdmin/{title}/{page}/{searchStyle}/{tag}")
    public BKSearchVideoListViewModel Search(@PathVariable("title") String SearchName,
                                              @PathVariable("page") Integer page,@PathVariable("searchStyle") String searchStyle,@PathVariable("tag") String tag){
         return  searchVideoByAdministrationService.selectByName(SearchName,page,searchStyle,tag);
    }

    @GetMapping("/SearchUserByAdmin/{title}/{page}/{searchStyle}/{tag}")
    public BKSearchUserByAdministrationViewModel Search2(@PathVariable("title") String SearchName,
                                                        @PathVariable("page") Integer page, @PathVariable("searchStyle") String searchStyle,@PathVariable("tag") String tag){
        return  searchUserByAdministrationService.selectByName(SearchName,page,searchStyle,tag);
    }
    //当搜索视频名为空时
    @GetMapping("/SearchVideoByAdmin/{page}/{searchStyle}/{tag}")
    public BKSearchVideoListViewModel Search3(@PathVariable("page") Integer page,@PathVariable("searchStyle") String searchStyle,@PathVariable("tag") String tag){
        return  searchVideoByAdministrationService.selectByName("",page,searchStyle,tag);
    }
    //当搜索用户名为空时
    @GetMapping("/SearchUserByAdmin/{page}/{searchStyle}/{tag}")
    public BKSearchUserByAdministrationViewModel Search4(@PathVariable("page") Integer page, @PathVariable("searchStyle") String searchStyle,@PathVariable("tag") String tag){
        return  searchUserByAdministrationService.selectByName("",page,searchStyle,tag);
    }

    @PutMapping("/ChangeUserState/{id}")
    public Long ChangeUserState(@PathVariable("id") Integer id){
        return changeStateService.changeUser(id);
    }

    @PutMapping("/ChangeVideoState/{id}")
    public Long ChangeVideoState(@PathVariable("id") Integer id){
        return changeStateService.changeVideo(id);
    }

    @PostMapping("/AdminLogin")
    public String AdminLogin(@RequestBody BKAdmin admin){
        return adminDetection.Detection(admin.getAccount(),admin.getPassword());
    }
}
