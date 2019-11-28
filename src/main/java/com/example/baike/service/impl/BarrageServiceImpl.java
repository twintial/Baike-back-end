package com.example.baike.service.impl;

import com.example.baike.constant.BarrageMap;
import com.example.baike.mapper.BarrageMapper;
import com.example.baike.model.*;
import com.example.baike.model.BKBarrageViewModel;
import com.example.baike.result.Result;
import com.example.baike.result.ResultFactory;
import com.example.baike.service.BarrageService;
import com.example.baike.util.RGBColorToIntUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class BarrageServiceImpl implements BarrageService {

    @Autowired
    BarrageMapper barrageMapper;
    @Override
    public Result insertBarrage(BKBarrageViewModel barrageViewModel, HttpSession session) {
        // 测试用暂时改成这样
//        BKUser user = (BKUser) session.getAttribute("user");
//        if (user == null){
//            return ResultFactory.buildFailResult("Please Login");
//        }
        Integer nRGB = RGBColorToIntUtil.RGBToInt(barrageViewModel.getColor());
        if (nRGB == null){
            return ResultFactory.buildFailResult("error occur when casting color");
        }
        BKBarrage barrage = new BKBarrage();
        barrage.setUID(Integer.parseInt(barrageViewModel.getAuthor()));
        barrage.setContent(barrageViewModel.getText());
        barrage.setVideoTime(barrageViewModel.getTime());
        barrage.setSendTime(new Date());
        barrage.setColor(nRGB);
        barrage.setBType(BarrageMap.typeMap.get(barrageViewModel.getType()));
        barrage.setVideoID(barrageViewModel.getPlayer());
        barrageMapper.insertBarrage(barrage);
        return ResultFactory.buildCustomResult(0, "success", barrage);
    }

    @Override
    public Object[][] selectAllBarragesByID(Integer vID) {
        List<ReadBarrageViewModel> proBarrages = barrageMapper.selectAllBarragesByID(vID);
        Object[][] barrages = new Object[proBarrages.size()][5];
        for (int i = 0; i < proBarrages.size(); i++) {
            ReadBarrageViewModel barrage = proBarrages.get(i);
            Object[] objects = {barrage.getTime(), barrage.getBType(), barrage.getColor(), barrage.getUID(), barrage.getContent()};
            barrages[i] = objects;
        }
        return barrages;
    }
}
