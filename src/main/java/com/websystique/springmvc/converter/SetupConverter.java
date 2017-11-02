package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.Setup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SetupConverter implements Converter<Object, Setup> {

    static final Logger logger = LoggerFactory.getLogger(SetupConverter.class);

    @Autowired
    IIdNameDao<Setup> setupService;

    public Setup convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Setup converted = setupService.findById(id);
        logger.info("Setup : {}", converted);
        return converted;
    }

}