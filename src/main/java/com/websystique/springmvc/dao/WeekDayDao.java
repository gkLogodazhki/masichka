package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.WeekDay;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("weekDayDao")
@Transactional
public class WeekDayDao extends AbstractDao<Integer, WeekDay> implements IIdNameDao<WeekDay> {

    @Override
    public WeekDay findById(Integer id) {
        return getByKey(id);
    }

    @Override
    public WeekDay findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (WeekDay) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<WeekDay> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<WeekDay>) crit.list();
    }
}