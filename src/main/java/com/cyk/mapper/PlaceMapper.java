package com.cyk.mapper;


import com.cyk.domain.Place;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PlaceMapper extends BaseMapper<Place,String> {


    List<Place> findByProvinceIdPage(@Param("start") Integer start, @Param("rows") Integer rows, @Param("provinceId") String provinceId);


    Integer findByProvinceIdCounts(String provinceId);




}
