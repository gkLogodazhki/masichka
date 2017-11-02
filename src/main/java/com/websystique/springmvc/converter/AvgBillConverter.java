package com.websystique.springmvc.converter;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.model.AvgBill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AvgBillConverter implements Converter<Object, AvgBill> {

    static final Logger logger = LoggerFactory.getLogger(AvgBillConverter.class);

    @Autowired
    IIdNameDao<AvgBill> avgBillService;

    public AvgBill convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        AvgBill avgBill = avgBillService.findById(id);
        logger.info("AvgBill : {}", avgBill);
        return avgBill;
    }

}