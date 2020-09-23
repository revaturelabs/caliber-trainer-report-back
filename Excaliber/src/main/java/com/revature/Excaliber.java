package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Excaliber.
 */
@SpringBootApplication
@RestController
public class Excaliber {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Excaliber.class, args);
    }

    /**
     * Home page used to check if spring is running
     *
     * @return the string
     */
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    /**
     * Cors configurer web mvc configurer.
     *
     * @return the web mvc configurer
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "OPTIONS", "PUT", "POST", "PATCH", "DELETE")
                        .allowedOrigins("http://excaliber.trainer.report.s3-website.us-east-2.amazonaws.com/").allowedHeaders("*").allowCredentials(true); // AssociateS3, should be changed.
            }
        };
    }


}
