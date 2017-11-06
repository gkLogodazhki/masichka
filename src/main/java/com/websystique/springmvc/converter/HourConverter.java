package com.websystique.springmvc.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.City;
import com.websystique.springmvc.model.Hour;

@Component
public class HourConverter implements Converter<Object, Hour> {

    static final Logger logger = LoggerFactory.getLogger(HourConverter.class);

    @Autowired
    IIdNameDao<Hour> hourService;

    public Hour convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Hour hour = hourService.findById(id);
        logger.info("Hour : {}", hour);
        return hour;
    }
}