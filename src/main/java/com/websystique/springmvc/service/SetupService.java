package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.Setup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("setupService")
@Transactional
public class SetupService implements IIdNameDao<Setup> {

    @Autowired
    private IIdNameDao<Setup> setupDao;

    @Override
    public Setup findById(Integer id) {
        return setupDao.findById(id);
    }

    @Override
    public Setup findByName(String type) {
        return setupDao.findByName(type);
    }

    @Override
    public List<Setup> findAll() {
        return setupDao.findAll();
    }

}