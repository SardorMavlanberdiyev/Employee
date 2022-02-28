package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.demo.controller"})
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/assets/css/**",
                "/assets/vendors/**",
                "/assets/images/**",
                "/assets/js/**"
        ).addResourceLocations(
                "classpath:/static/assets/css/",
                "classpath:/static/assets/vendors/",
                "classpath:/static/assets/images/",
                "classpath:/static/assets/js/"
        );
    }
}
