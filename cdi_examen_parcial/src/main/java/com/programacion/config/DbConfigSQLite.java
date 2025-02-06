package com.programacion.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.apache.deltaspike.core.api.config.ConfigProperty;

import javax.sql.DataSource;

@ApplicationScoped
public class DbConfigSQLite {

    @Inject
    @ConfigProperty(name="database.url")
    private String databaseUrl;

    @Inject
    @ConfigProperty(name="database.user")
    private String databaseUser;

    @Inject
    @ConfigProperty(name="database.password")
    private String databasePassword;

    @Produces
    @ApplicationScoped
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("org.sqlite.JDBC");
        config.setJdbcUrl(databaseUrl);
        config.setUsername(databaseUser);
        config.setPassword(databasePassword);

        DataSource ds = new HikariDataSource(config);

        return ds;
    }
}
