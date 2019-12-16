package com.example.baike.service;

import org.apache.ibatis.annotations.Param;

public interface ChangeStateService {
    Long changeUser(Integer ID);
    Long changeVideo(Integer ID);
}
