package com.example.baike.service;

import com.example.baike.model.BKUser;
import com.example.baike.state.UserState;

public interface LoginService {
    BKUser selectByAccount(String account);
    UserState selectStateByUID(Integer uID);
}
