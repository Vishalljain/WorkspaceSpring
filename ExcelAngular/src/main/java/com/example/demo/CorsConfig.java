//package com.example.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class CorsConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        // Allow requests from this origin (Angular app)
//        config.addAllowedOrigin("http://localhost:4200");
//
//        // Allow specific HTTP methods (e.g., GET, POST, PUT, DELETE)
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("DELETE");
//
//        // Allow specific headers (e.g., Content-Type, Authorization)
//        config.addAllowedHeader("Content-Type");
//        config.addAllowedHeader("Authorization");
//
//        source.registerCorsConfiguration("/**", config);
//
//        return new CorsFilter(source);
//    }
//}
//
