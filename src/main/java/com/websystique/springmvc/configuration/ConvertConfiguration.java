package com.websystique.springmvc.configuration;

import com.websystique.springmvc.converter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.websystique.springmvc")
public class ConvertConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    UserTypeConverter userTypeConverter;

    @Autowired
    AvgBillConverter avgBillConverter;

    @Autowired
    CityConverter cityConverter;

    @Autowired
    OptionConverter optionConverter;

    @Autowired
    PayMethodConverter payMethodConverter;

    @Autowired
    PlaceTypeConverter placeTypeConverter;

    @Autowired
    RegionConverter regionConverter;

    @Autowired
    SetupConverter setupConverter;

    @Autowired
    WeekDayConverter weekDayConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userTypeConverter);
        registry.addConverter(cityConverter);
        registry.addConverter(optionConverter);
        registry.addConverter(payMethodConverter);
        registry.addConverter(placeTypeConverter);
        registry.addConverter(regionConverter);
        registry.addConverter(setupConverter);
        registry.addConverter(weekDayConverter);
    }
}
