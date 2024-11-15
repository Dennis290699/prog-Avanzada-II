package com.programacion.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;

@ApplicationScoped
public class DbConfig {

    @Produces
    @ApplicationScoped
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
