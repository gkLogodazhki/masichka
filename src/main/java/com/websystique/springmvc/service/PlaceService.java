package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.dao.IPlaceDao;
import com.websystique.springmvc.model.Place;
import com.websystique.springmvc.model.PlaceType;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("placeService")
@Transactional
public class PlaceService extends AbstractDao<Integer, Place> implements IPlaceDao {

    static final Logger logger = LoggerFactory.getLogger(PlaceService.class);

    @Autowired
    IIdNameDao<PlaceType> placeTypeDao;

    public Place findById(Integer id) {
        Place place = getByKey(id);
        if (place != null) {
            initialize(place);
        }
        return place;
    }

    @Override
    public List<Place> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Place> places = (List<Place>) criteria.list();
        return places;
    }

    @Override
    public Place findByName(String name) {
        logger.info("NAME : {}", name);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        Place place = (Place) crit.uniqueResult();
        if (place!= null){
            initialize(place);
        }
        return place;
    }

    public List<Place> find(PlaceType placeType, Order order) {
        Criteria criteria = createEntityCriteria().addOrder(order);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("placeType",placeType.getId()));
        criteria.setMaxResults(6);
        List<Place> places = (List<Place>) criteria.list();
        if (places.size() == 0){
            for (Place place : places){
                initialize(place);
            }
        }
        return places;
    }

    @Override
    public void save(Place place) {
        persist(place);
    }

    @Override
    public void delete(Place place) {
        delete(place);
    }

    public boolean isNameUnique(Integer id, String name) {
        Place place = findByName(name);
        return ( place == null || ((id != null) && (place.getId() == id)));
    }

    private void initialize(Place place){
        Hibernate.initialize(place.getSetups());
        Hibernate.initialize(place.getRegion());
        Hibernate.initialize(place.getPlaceType());
        Hibernate.initialize(place.getPayMethods());
//            Hibernate.initialize(place.getComments());
        Hibernate.initialize(place.getAvgBill());
        Hibernate.initialize(place.getOptions());
    }

    @Override
    public void update(Place entity) {
        super.update(entity);
    }
}
