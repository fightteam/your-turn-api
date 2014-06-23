package org.fightteam.yourturn.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring mvc 的javaconfig配置
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.fightteam.yourturn.api.web")
public class WebSpringConfig extends WebMvcConfigurerAdapter {

}
