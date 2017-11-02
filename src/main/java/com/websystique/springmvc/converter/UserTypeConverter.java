package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class UserTypeConverter implements Converter<Object, UserType> {

    static final Logger logger = LoggerFactory.getLogger(UserTypeConverter.class);

    @Autowired
    IIdNameDao<UserType> userTypeService;

    public UserType convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        UserType profile = userTypeService.findById(id);
        logger.info("UserType : {}", profile);
        return profile;
    }

}