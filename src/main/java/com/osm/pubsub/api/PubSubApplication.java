package com.osm.pubsub.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class PubSubApplication {
    public static void main(String[] args) throws IOException, SQLException {
        SpringApplication.run(PubSubApplication.class, args);


    }
}