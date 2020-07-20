package com.cyk.service.impl;


import com.cyk.domain.Province;
import com.cyk.mapper.ProvinceMapper;
import com.cyk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;


    @Override
    public List<Province> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return provinceMapper.findByPage(start,rows);
    }

    @Override
    public Province findOne(String id) {
        return provinceMapper.findOne(id);
    }

    @Override
    public void update(Province province) {
        provinceMapper.update(province);
    }

    @Override
    public void delete(String id) {
        provinceMapper.delete(id);
    }

    @Override
    public void save(Province province) {
        province.setPlacecounts(0);//景点个数为零
        provinceMapper.save(province);
    }

    @Override
    public Integer findTotals() {
        return provinceMapper.findTotals();
    }
}
