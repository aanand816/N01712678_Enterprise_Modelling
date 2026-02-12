package com.week5.restapi; // or com.weekNo.restapi

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestapiApplication {

    private static final Logger log = LoggerFactory.getLogger(RestapiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
        System.out.println("Application Started Successfully -> Check the link below");
        System.out.println("http://localhost:8080/countries/US");
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }



}
