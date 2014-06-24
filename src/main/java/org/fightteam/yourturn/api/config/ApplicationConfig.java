package org.fightteam.yourturn.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * spring 的javaconfig配置
 */
@Configuration
@ComponentScan(basePackages = "org.fightteam.yourturn.api", excludeFilters = {
        @ComponentScan.Filter(Controller.class),
        @ComponentScan.Filter(ControllerAdvice.class),
        @ComponentScan.Filter(Configuration.class)})
public class ApplicationConfig {

    @Bean
    public DataSource dataSource() {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:jboss/datasources/mySQLDB");
    }
}
