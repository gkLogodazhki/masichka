package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Place;
import com.websystique.springmvc.model.PlaceType;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("placeDao")
@Transactional
public class PlaceDao extends AbstractDao<Integer, Place> implements IPlaceDao {

    static final Logger logger = LoggerFactory.getLogger(PlaceDao.class);

    @Autowired
    IIdNameDao<PlaceType> placeTypeDao;

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

    public Place findById(Integer id) {
        Place place = getByKey(id);
        if (place != null) {
            initialize(place);
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
    public List<Place> findByPlaceType(PlaceType placeType, Integer count) {
        if (placeType == null){
            return null;
        }
        logger.info("PLACETYPE : {}", placeType);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("placeType",placeType.getId()));
        crit.setMaxResults(count);
        List<Place> places = (List<Place>) crit.uniqueResult();
        if (places!= null){
            for (Place place : places){
                initialize(place);
            }
        }
        return places;
    }

    @Override
    public boolean isNameUnique(Integer id, String name) {
        return false;
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


}

