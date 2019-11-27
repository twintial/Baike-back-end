package com.example.baike.service;

import com.example.baike.model.BKUser;
import com.example.baike.result.Result;

public interface RegisterService {
    Result register(String account, String pwd, String nickName);
}
