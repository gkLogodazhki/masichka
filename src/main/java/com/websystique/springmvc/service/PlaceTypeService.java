package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.PlaceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("placeTypeService")
@Transactional
public class PlaceTypeService implements IIdNameDao<PlaceType> {

    @Autowired
    private IIdNameDao<PlaceType> placeTypeDao;

    @Override
    public PlaceType findById(Integer id) {
        return placeTypeDao.findById(id);
    }

    @Override
    public PlaceType findByName(String type) {
        return placeTypeDao.findByName(type);
    }

    @Override
    public List<PlaceType> findAll() {
        return placeTypeDao.findAll();
    }

}