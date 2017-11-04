package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Place;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("placeDao")
@Transactional
public class PlaceDao extends AbstractDao<Integer, Place> implements IPlaceDao {

    static final Logger logger = LoggerFactory.getLogger(PlaceDao.class);

    @Override
    public Place findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (Place) crit.uniqueResult();
    }

    public Place findById(Integer id) {
        Place place = getByKey(id);
        if (place != null) {
            Hibernate.initialize(place.getFavouritePlaces());
            Hibernate.initialize(place.getWeekDays());
            Hibernate.initialize(place.getSetups());
            Hibernate.initialize(place.getReservations());
            Hibernate.initialize(place.getRegion());
            Hibernate.initialize(place.getPlaceType());
            Hibernate.initialize(place.getPayMethods());
            Hibernate.initialize(place.getComments());
            Hibernate.initialize(place.getAvgBill());
            Hibernate.initialize(place.getOptions());
        }
        return place;
    }

    public List<Place> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Place> places = (List<Place>) criteria.list();
        return places;
    }

    @Override
    public void save(Place place) {
        persist(place);
    }

    @Override
    public boolean isUnique(Integer id, String name) {
        Place place = findByName(name);
        return (name == null || ((id != null) && (place.getId() == id)));
    }

}

