package org.fightteam.yourturn.api.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.data.geo.GeoModule;
import org.springframework.data.web.config.HateoasAwareSpringDataWebConfiguration;
import org.springframework.data.web.config.SpringDataJacksonConfiguration;
import org.springframework.hateoas.*;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by excalibur on 2014/6/26.
 */
@Configuration
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
//@ComponentScan(basePackageClasses = RepositoryRestController.class,
//        includeFilters = @ComponentScan.Filter(RepositoryRestController.class), useDefaultFilters = false)
@Import(SpringDataJacksonConfiguration.class)
public class WebRestConfig extends HateoasAwareSpringDataWebConfiguration {

    @Autowired
    ListableBeanFactory beanFactory;

    @Autowired
    GeoModule geoModule;


    @PostConstruct
    public void setUp() {
        System.out.println("========================");

    }

//    @Bean
//    public EntityLinks entityLinks() {
//        return new RepositoryEntityLinks(repositories(), resourceMappings(), config(), pageableResolver(),
//                backendIdConverterRegistry());
//    }


//    @Bean
//    public MappingJackson2HttpMessageConverter jacksonHttpMessageConverter() {
//
//        List<MediaType> mediaTypes = new ArrayList<MediaType>();
//        mediaTypes.addAll(Arrays.asList(MediaType.valueOf("application/json"),
//                MediaType.valueOf("application/schema+json")));
//        System.out.println("======");
//        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
//        jacksonConverter.setObjectMapper(objectMapper());
//        jacksonConverter.setSupportedMediaTypes(mediaTypes);
//
//        return jacksonConverter;
//    }
//
//
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        return basicObjectMapper();
//    }
//
//    private ObjectMapper basicObjectMapper() {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//        // Our special PersistentEntityResource Module
//        //objectMapper.registerModule(persistentEntityJackson2Module());
//        objectMapper.registerModule(geoModule);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        //Jackson2DatatypeHelper.configureObjectMapper(objectMapper);
//
//        return objectMapper;
//    }




}
