package edu.miu.labthree;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class LabThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabThreeApplication.class, args);
    }
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

}
