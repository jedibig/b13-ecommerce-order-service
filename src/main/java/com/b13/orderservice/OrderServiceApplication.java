package com.b13.orderservice;

//import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

//    @Bean
//    ApplicationRunner runner(DataSource dataSource){
//        return a -> {
//            Flyway flyway = Flyway.configure().dataSource(dataSource).load();
//            flyway.migrate();
//        };
//    }
}
