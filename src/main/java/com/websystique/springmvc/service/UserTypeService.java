package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userTypeService")
@Transactional
public class UserTypeService implements IIdNameDao<UserType> {

    @Autowired
    private IIdNameDao<UserType> userTypeDao;

    @Override
    public UserType findById(Integer id) {
        return userTypeDao.findById(id);
    }

    @Override
    public UserType findByName(String name) {
        return userTypeDao.findByName(name);
    }

    @Override
    public List<UserType> findAll() {
        return userTypeDao.findAll();
    }

}
