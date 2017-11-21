package com.zenika;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("com.zenika")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {


    // public static final String URL = "jdbc:postgresql://localhost:5432/spring_workshop";
    // public static final String USERNAME = "postgres";
    // public static final String PASSWORD = "postgres";

    @Value("${database.url}")
    private String URL;

    @Value("${database.username}")
    private String USERNAME;

    @Value("${database.password}")
    private String PASSWORD;

    @Value("${database.driverName}")
    private String DRIVER_NAME;


    @Bean
    @Profile("prod")
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
    public Connection connection() {

        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
