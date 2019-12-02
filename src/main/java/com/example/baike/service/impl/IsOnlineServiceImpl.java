package com.example.baike.service.impl;

import com.example.baike.service.IsOnlineService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class IsOnlineServiceImpl implements IsOnlineService {
    @Override
    public boolean test(HttpSession session) {
        if(session.getAttribute("user")==null) return false;
        else return true;
    }
}
