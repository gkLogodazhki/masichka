package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.WeekDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("weekDayService")
@Transactional
public class WeekDayService implements IIdNameDao<WeekDay> {

    @Autowired
    @Qualifier(value = "weekDayDao")
    private IIdNameDao<WeekDay> weekDayDao;

    @Override
    public WeekDay findById(Integer id) {
        return weekDayDao.findById(id);
    }

    @Override
    public WeekDay findByName(String type) {
        return weekDayDao.findByName(type);
    }

    @Override
    public List<WeekDay> findAll() {
        return weekDayDao.findAll();
    }

}