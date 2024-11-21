package com.programacion.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ApplicationScoped
public class DbConfig {

    public Connection getConection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://ep-tight-cake-a5kbaeqg.us-east-2.aws.neon.tech/transferencias",
                    "transferencias_owner",
                    "fqymeF0XlJW2");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
