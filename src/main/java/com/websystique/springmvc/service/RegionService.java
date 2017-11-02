package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("regionService")
@Transactional
public class RegionService implements IIdNameDao<Region> {

    @Autowired
    private IIdNameDao<Region> regionDao;

    @Override
    public Region findById(Integer id) {
        return regionDao.findById(id);
    }

    @Override
    public Region findByName(String type) {
        return regionDao.findByName(type);
    }

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

}