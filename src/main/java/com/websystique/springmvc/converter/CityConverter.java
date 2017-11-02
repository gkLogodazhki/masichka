package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CityConverter implements Converter<Object, City> {

    static final Logger logger = LoggerFactory.getLogger(CityConverter.class);

    @Autowired
    IIdNameDao<City> cityService;

    public City convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        City city = cityService.findById(id);
        logger.info("City : {}", city);
        return city;
    }
}

