package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Place;

public interface IPlaceDao extends IIdNameDao<Place> {

    void save(Place place);

    void delete(Place place);

}
