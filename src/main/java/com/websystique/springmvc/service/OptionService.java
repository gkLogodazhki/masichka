package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("optionService")
@Transactional
public class OptionService implements IIdNameDao<Option> {

    @Autowired
    private IIdNameDao<Option> optionDao;

    @Override
    public Option findById(Integer id) {
        return optionDao.findById(id);
    }

    @Override
    public Option findByName(String type) {
        return optionDao.findByName(type);
    }

    @Override
    public List<Option> findAll() {
        return optionDao.findAll();
    }

}