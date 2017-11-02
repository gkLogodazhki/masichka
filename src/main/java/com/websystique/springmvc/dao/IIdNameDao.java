package com.websystique.springmvc.dao;

import java.util.List;

public interface IIdNameDao<E> {
    List<E> findAll();

    E findByName(String type);

    E findById(Integer id);
}
