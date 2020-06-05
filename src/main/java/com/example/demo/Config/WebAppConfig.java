package com.example.demo.Config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.example.demo.Mapper.ICheckInfoMapper;


@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter((Converter<?, ?>) new DateConverter());
    }
    
    
}
