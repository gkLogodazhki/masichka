package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.AvgBill;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("avgBillDao")
@Transactional
public class AvgBillDao extends AbstractDao<Integer, AvgBill> implements IIdNameDao<AvgBill> {

    @Override
    public AvgBill findById(Integer id) { return getByKey(id);}

    @Override
    public AvgBill findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (AvgBill) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AvgBill> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<AvgBill>) crit.list();
    }
}
