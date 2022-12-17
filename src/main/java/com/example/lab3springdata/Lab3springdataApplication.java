package com.example.lab3springdata;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab3springdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab3springdataApplication.class, args);
    }
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
