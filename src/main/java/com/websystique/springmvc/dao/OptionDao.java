package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Option;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("optionDao")
@Transactional
public class OptionDao extends AbstractDao<Integer, Option> implements IIdNameDao<Option> {

    @Override
    public Option findById(Integer id) { return getByKey(id);}

    @Override
    public Option findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (Option) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Option> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<Option>) crit.list();
    }
}