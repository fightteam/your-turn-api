package org.fightteam.yourturn.api.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.GeoModule;
import org.springframework.hateoas.LinkBuilderFactory;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.nio.charset.Charset;
import java.util.*;

/**
 * spring mvc 的javaconfig配置
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.fightteam.yourturn.api.web",
        includeFilters = {@ComponentScan.Filter(Controller.class),
                @ComponentScan.Filter(ControllerAdvice.class)},
        useDefaultFilters = false)
public class WebSpringConfig extends WebMvcConfigurerAdapter {

    @Autowired
    GeoModule geoModule;
    /**
     * 静态资源控制
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {


        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.addAll(Arrays.asList(MediaType.valueOf("application/json"),
                MediaType.valueOf("application/schema+json")));
        System.out.println("======");
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        jacksonConverter.setObjectMapper(objectMapper());
        jacksonConverter.setSupportedMediaTypes(mediaTypes);

        converters.add(jacksonConverter);

    }

    @Bean
    public ObjectMapper objectMapper() {
        return basicObjectMapper();
    }

    private ObjectMapper basicObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        // Our special PersistentEntityResource Module
        //objectMapper.registerModule(persistentEntityJackson2Module());
        objectMapper.registerModule(geoModule);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Jackson2DatatypeHelper.configureObjectMapper(objectMapper);

        return objectMapper;
    }


    @Bean
    public MappingJackson2HttpMessageConverter jsonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }
}
