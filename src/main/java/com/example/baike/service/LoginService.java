package com.example.baike.service;

import com.example.baike.result.Result;

import javax.servlet.http.HttpSession;

public interface LoginService {
    Result login(String account, String psw, HttpSession session);
}
