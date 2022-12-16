package edu.miu.springsecurity1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSecurity1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity1Application.class, args);
    }

    @Bean
    public ModelMapper getModelMapperBean() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
