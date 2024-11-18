package com.programacion.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DbConfig {

    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("org.sqlite.JDBC");
        config.setJdbcUrl("jdbc:sqlite:transferencias.db");
        config.setUsername("sa");
        config.setPassword("");

        DataSource ds = new HikariDataSource(config);

        return ds;
    }
}
