package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cityService")
@Transactional
public class CityService implements IIdNameDao<City> {

    @Autowired
    private IIdNameDao<City> cityDao;

    @Override
    public City findById(Integer id) {
        return cityDao.findById(id);
    }

    @Override
    public City findByName(String type) {
        return cityDao.findByName(type);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

}