package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.dao.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public void getCity(){
        System.out.println(cityMapper.findByState("CA"));
    }
}
