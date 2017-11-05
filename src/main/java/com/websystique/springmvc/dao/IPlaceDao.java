package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Place;
import com.websystique.springmvc.model.PlaceType;

import java.util.List;

public interface IPlaceDao extends IIdNameDao<Place> {

    void save(Place place);

    void delete(Place place);

    List<Place> findByPlaceType(PlaceType placeType, Integer count);

    boolean isNameUnique(Integer id, String name);
}
