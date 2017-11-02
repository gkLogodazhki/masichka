package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.PayMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class PayMethodConverter implements Converter<Object, PayMethod> {

    static final Logger logger = LoggerFactory.getLogger(PayMethodConverter.class);

    @Autowired
    IIdNameDao<PayMethod> payMethodService;

    public PayMethod convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        PayMethod converted = payMethodService.findById(id);
        logger.info("PayMethod : {}", converted);
        return converted;
    }

}