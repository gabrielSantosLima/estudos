package com.gabriel.celebration.adapters.config;

import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JooqConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceConnectionProvider connectionProvider(){
        return new DataSourceConnectionProvider(
                new TransactionAwareDataSourceProxy(dataSource)
        );
    }

    @Bean
    public DefaultDSLContext dsl(){
        return new DefaultDSLContext(configuration());
    }

    private DefaultConfiguration configuration(){
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.set(connectionProvider());
        defaultConfiguration.set(new DefaultExecuteListenerProvider(new JooqExceptionTranslator()));

        return defaultConfiguration;
    }
}
