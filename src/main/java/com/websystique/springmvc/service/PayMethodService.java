package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.PayMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("payMethodService")
@Transactional
public class PayMethodService implements IIdNameDao<PayMethod> {

    @Autowired
    private IIdNameDao<PayMethod> payMethodDao;

    @Override
    public PayMethod findById(Integer id) {
        return payMethodDao.findById(id);
    }

    @Override
    public PayMethod findByName(String type) {
        return payMethodDao.findByName(type);
    }

    @Override
    public List<PayMethod> findAll() {
        return payMethodDao.findAll();
    }

}