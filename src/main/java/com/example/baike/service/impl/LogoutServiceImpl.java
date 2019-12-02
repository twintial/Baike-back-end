package com.example.baike.service.impl;

import com.example.baike.service.LogoutService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class LogoutServiceImpl implements LogoutService {
    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
}
