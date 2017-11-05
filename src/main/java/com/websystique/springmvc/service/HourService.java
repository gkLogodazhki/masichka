package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.City;
import com.websystique.springmvc.model.Hour;

@Service("hourService")
@Transactional
public class HourService implements IIdNameDao<Hour> {

    @Autowired
    private IIdNameDao<Hour> hourDao;

    @Override
    public Hour findById(Integer id) {
        return hourDao.findById(id);
    }

    @Override
    public Hour findByName(String name) {
        return hourDao.findByName(name);
    }

    @Override
    public List<Hour> findAll() {
        return hourDao.findAll();
    }

}
