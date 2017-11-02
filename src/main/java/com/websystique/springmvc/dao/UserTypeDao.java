package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.UserType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userTypeDao")
@Transactional
public class UserTypeDao extends AbstractDao<Integer, UserType> implements IIdNameDao<UserType> {

    @Override
    public UserType findById(Integer id) {
        return getByKey(id);
    }

    @Override
    public UserType findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (UserType) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserType> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<UserType>) crit.list();
    }
}