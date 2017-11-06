package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Place;
import com.websystique.springmvc.model.PlaceType;
import org.hibernate.criterion.Order;

import java.util.List;

public interface IPlaceDao extends IIdNameDao<Place> {

    void save(Place place);

    void delete(Place place);

    boolean isNameUnique(Integer id, String name);

    List<Place> find(PlaceType placeType, Order order);

}
