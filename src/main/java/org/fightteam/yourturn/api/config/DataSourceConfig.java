package org.fightteam.yourturn.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by excalibur on 2014/6/24.
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    private final static Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

    @Value("${database.envContextName}")
    private String envContextName;

    @Value("${database.lookupName}")
    private String lookupName;

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup(envContextName);
            DataSource ds = (DataSource) envContext.lookup(lookupName);
            return ds;
        } catch (NamingException e) {
            log.error("create data source error", e);
        }
        return null;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource());
        return txManager;
    }
}
