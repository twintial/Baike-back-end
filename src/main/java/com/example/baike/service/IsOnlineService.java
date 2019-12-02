package com.example.baike.service;

import javax.servlet.http.HttpSession;

public interface IsOnlineService {
    boolean test(HttpSession session);
}
