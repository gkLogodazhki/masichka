package com.websystique.springmvc.dao;


import com.websystique.springmvc.model.PlaceType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("placeTypeDao")
@Transactional
public class PlaceTypeDao extends AbstractDao<Integer, PlaceType> implements IIdNameDao<PlaceType> {

    @Override
    public PlaceType findById(Integer id) {
        return getByKey(id);
    }


    @Override
    public PlaceType findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (PlaceType) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PlaceType> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<PlaceType>) crit.list();
    }
}