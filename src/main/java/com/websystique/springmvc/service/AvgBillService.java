package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.AvgBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("avgBillService")
@Transactional
public class AvgBillService implements IIdNameDao<AvgBill> {

    @Autowired
    private IIdNameDao<AvgBill> avgBillDao;

    @Override
    public AvgBill findById(Integer id) {
        return avgBillDao.findById(id);
    }

    @Override
    public AvgBill findByName(String type) {
        return avgBillDao.findByName(type);
    }

    @Override
    public List<AvgBill> findAll() {
        return avgBillDao.findAll();
    }

}