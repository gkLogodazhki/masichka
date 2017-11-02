package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IPlaceDao;
import com.websystique.springmvc.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("placeService")
@Transactional
public class PlaceServices implements IPlaceDao {

    @Autowired
    private IPlaceDao placeDao;

    @Override
    public void save(Place place) {
        placeDao.save(place);
    }

    @Override
    public void delete(Place place) {
        placeDao.delete(place);
    }

    @Override
    public boolean isUnique(Integer id, String name) {
        return placeDao.isUnique(id, name);
    }

    @Override
    public List<Place> findAll() {
        return placeDao.findAll();
    }

    @Override
    public Place findByName(String name) {
        return placeDao.findByName(name);
    }

    @Override
    public Place findById(Integer id) {
        return placeDao.findById(id);
    }
}
