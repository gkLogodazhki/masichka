package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Option;
import com.websystique.springmvc.model.PlaceType;
import com.websystique.springmvc.model.PlacesHasOption;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class PlacesHasOptionsDao extends AbstractDao<Integer, PlacesHasOption> implements IOneToManyDao {

    @Override
    public List<Option> findById(Integer id) {
        List<Option> options = createEntityCriteria().add(Restrictions.eq("place_id",id)).list();
        return options;
    }

}