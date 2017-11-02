package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.PlacesHasOption;

import java.util.List;

public interface IOneToManyDao<E> {

    List<E> findById(Integer id);

}

