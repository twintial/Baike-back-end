package com.example.baike.service;

import com.example.baike.model.BKUser;
import com.example.baike.model.BKUserInfo;

public interface RegisterService {
    Long userRegister(BKUser user);
    Long addInfo(BKUserInfo info);
    Long rollBackUser(BKUser user);
}
