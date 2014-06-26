package org.fightteam.yourturn.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring mvc 的javaconfig配置
 */
@Configuration
@EnableWebMvc
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@ComponentScan(basePackages = "org.fightteam.yourturn.api.web",
        includeFilters = {@ComponentScan.Filter(Controller.class),
                @ComponentScan.Filter(ControllerAdvice.class)},
        useDefaultFilters = false)
public class WebSpringConfig extends WebMvcConfigurerAdapter {

}
