package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.PayMethod;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("payMethodDao")
@Transactional
public class PayMethodDao extends AbstractDao<Integer, PayMethod> implements IIdNameDao<PayMethod> {

    @Override
    public PayMethod findById(Integer id) { return getByKey(id); }

    @Override
    public PayMethod findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (PayMethod) crit.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PayMethod> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("name"));
        return (List<PayMethod>) crit.list();
    }
}