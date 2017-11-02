package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.WeekDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WeekDayConverter implements Converter<Object, WeekDay> {

    static final Logger logger = LoggerFactory.getLogger(WeekDayConverter.class);

    @Autowired
    IIdNameDao<WeekDay> weekDayService;

    public WeekDay convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        WeekDay converted = weekDayService.findById(id);
        logger.info("WeekDay : {}", converted);
        return converted;
    }

}