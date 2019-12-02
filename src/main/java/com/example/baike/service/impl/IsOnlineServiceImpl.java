package com.example.baike.service.impl;

import com.example.baike.model.BKUser;
import com.example.baike.service.IsOnlineService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class IsOnlineServiceImpl implements IsOnlineService {
    @Override
    public Integer test(HttpSession session) {
        if(session.getAttribute("user")==null) return -1;
        else return ((BKUser)session.getAttribute("user")).getUID() ;
    }
}
