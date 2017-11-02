package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OptionConverter implements Converter<Object, Option> {

    static final Logger logger = LoggerFactory.getLogger(OptionConverter.class);

    @Autowired
    IIdNameDao<Option> optionService;

    public Option convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Option option = optionService.findById(id);
        logger.info("Option : {}", option);
        return option;
    }

}