package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Region;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("regionDao")
@Transactional
public class RegionDao extends AbstractDao<Integer, Region> implements IIdNameDao<Region> {

    @Override
    public Region findById(Integer id) {
        Region region = getByKey(id);
        if (region != null) {
            Hibernate.initialize(region.getPlaces());
            Hibernate.initialize(region.getCity());
        }
        return getByKey(id);
    }

    @Override
    public Region findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (Region) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Region> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<Region>) crit.list();
    }
}