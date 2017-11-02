package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.City;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("cityDao")
@Transactional
public class CityDao extends AbstractDao<Integer, City> implements IIdNameDao<City> {

    @Override
    public City findById(Integer id) {
        return getByKey(id);
    }

    @Override
    public City findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (City) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<City> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<City>) crit.list();
    }
}