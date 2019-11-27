package com.example.baike.service;

import com.example.baike.model.BKBarrageViewModel;
import com.example.baike.model.ReadBarrageViewModel;
import com.example.baike.result.Result;

import javax.servlet.http.HttpSession;

public interface BarrageService {
    Result insertBarrage(BKBarrageViewModel barrageViewModel, HttpSession session);
    ReadBarrageViewModel selectAllBarragesByVID(Integer vID);
}
