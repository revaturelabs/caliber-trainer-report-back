package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class Excaliber {

    public static void main(String[] args) {
        SpringApplication.run(Excaliber.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "OPTIONS", "PUT", "POST", "PATCH", "DELETE")
                        .allowedOrigins("http://localhost:4200").allowedHeaders("*").allowCredentials(true);
            }
        };
    }


}
