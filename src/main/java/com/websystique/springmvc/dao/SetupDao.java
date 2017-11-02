package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Setup;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("setupDao")
@Transactional
public class SetupDao extends AbstractDao<Integer, Setup> implements IIdNameDao<Setup> {

    @Override
    public Setup findById(Integer id) {
        return getByKey(id);
    }

    @Override
    public Setup findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (Setup) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Setup> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<Setup>) crit.list();
    }
}