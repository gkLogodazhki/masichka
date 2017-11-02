package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RegionConverter implements Converter<Object, Region> {

    static final Logger logger = LoggerFactory.getLogger(RegionConverter.class);

    @Autowired
    IIdNameDao<Region> regionService;

    public Region convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Region converted = regionService.findById(id);
        logger.info("Region : {}", converted);
        return converted;
    }

}