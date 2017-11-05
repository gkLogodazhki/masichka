package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Hour;

@Repository("cityDao")
@Transactional
public class HourDao extends AbstractDao<Integer, Hour> implements IHourDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<Hour> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("name"));
		return (List<Hour>) crit.list();
	}

	@Override
	public Hour findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (Hour) crit.uniqueResult();
	}

	@Override
    public Hour findById(Integer id) {
        return getByKey(id);
    }
	
}
