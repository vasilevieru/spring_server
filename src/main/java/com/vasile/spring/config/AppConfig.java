package com.vasile.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Vasile on 20.05.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.vasile.spring")
public class AppConfig {


    private DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/Chisinau");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("administrator");
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
