package com.example.lsis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String... args) {

        SpringApplication.run(OrderServiceApplication.class, args);
    }

//    @Bean
//    ServiceCredentials serviceCredentials(@Value("${vcap.services}") String vcapServices) {
//        return new ServiceCredentials(vcapServices);
//    }
}
