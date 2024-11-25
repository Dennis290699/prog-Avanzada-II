package com.programacion.config;

import com.arjuna.ats.jdbc.TransactionalDriver;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.postgresql.xa.PGXAConnection;
import org.postgresql.xa.PGXADataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@ApplicationScoped
public class DbConfig {

    @Inject
    @ConfigProperty(name="database.url")
    private String databaseUrl;

    @Inject
    @ConfigProperty(name="database.user")
    private String databaseUser;

    @Inject
    @ConfigProperty(name="database.password")
    private String databasePassword;

    private PGXADataSource ds;

    @PostConstruct
    void init() {
        ds = new PGXADataSource();
        ds.setURL(databaseUrl);
        ds.setUser(databaseUser);
        ds.setPassword(databasePassword);
    }

    public Connection getConection() {

        Properties props = new Properties();
        props.put(TransactionalDriver.XADataSource, ds);

        try {
            return DriverManager.getConnection(TransactionalDriver.arjunaDriver,props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
