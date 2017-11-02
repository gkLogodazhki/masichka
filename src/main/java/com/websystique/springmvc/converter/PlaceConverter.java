package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PlaceConverter implements Converter<Object, Place> {

    static final Logger logger = LoggerFactory.getLogger(PlaceConverter.class);

    @Autowired
    IIdNameDao<Place> PlaceService;

    public Place convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Place converted = PlaceService.findById(id);
        logger.info("PayMethod : {}", converted);
        return converted;
    }

}