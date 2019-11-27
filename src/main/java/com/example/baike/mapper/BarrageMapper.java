package com.example.baike.mapper;

import com.example.baike.model.BKBarrage;
import com.example.baike.model.ReadBarrageViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BarrageMapper {
    Long insertBarrage(BKBarrage barrage);
    List<ReadBarrageViewModel> selectAllBarragesByID(@Param("vID") Integer vID);
}
