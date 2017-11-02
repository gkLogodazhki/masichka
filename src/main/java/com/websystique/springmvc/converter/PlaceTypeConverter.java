package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.PlaceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlaceTypeConverter implements Converter<Object, PlaceType> {

    static final Logger logger = LoggerFactory.getLogger(PlaceTypeConverter.class);

    @Autowired
    IIdNameDao<PlaceType> placeTypeService;

    public PlaceType convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        PlaceType converted = placeTypeService.findById(id);
        logger.info("PlaceType : {}", converted);
        return converted;
    }

}