package com.cyk.service.impl;


import com.cyk.domain.Place;
import com.cyk.domain.Province;
import com.cyk.mapper.PlaceMapper;
import com.cyk.service.PlaceService;
import com.cyk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {


    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public void update(Place place) {
        placeMapper.update(place);
    }

    @Override
    public Place findOne(String id) {
        return placeMapper.findOne(id);
    }

    @Autowired
    private ProvinceService provinceService;

    @Override
    public void delete(String id) {
        //直接删除景点  更新省份景点个数 删除景点
        Place place = placeMapper.findOne(id);
        Province province = provinceService.findOne(place.getProvinceid());
        province.setPlacecounts(province.getPlacecounts()-1);
        provinceService.update(province);
        //删除景点信息
        placeMapper.delete(id);
    }

    @Override
    public void save(Place place) {
        //保存景点
        placeMapper.save(place);
        //查询原始省份信息
        Province province = provinceService.findOne(place.getProvinceid());
        //更新省份信息的景点个数
        province.setPlacecounts(province.getPlacecounts()+1);
        provinceService.update(province);

    }

    @Override
    public List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId) {
        int start = (page-1)*rows;
        return placeMapper.findByProvinceIdPage(start,rows,provinceId);
    }

    @Override
    public Integer findByProvinceIdCounts(String provinceId) {
        return placeMapper.findByProvinceIdCounts(provinceId);
    }
}
