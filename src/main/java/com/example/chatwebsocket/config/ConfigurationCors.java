package com.example.chatwebsocket.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ConfigurationCors {

   @Bean
   CorsConfigurationSource configurationSource() {
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowedOriginPatterns(List.of("*"));
      config.setAllowedOrigins(List.of("http://localhost:4200"));
      config.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE"));
      config.setAllowedHeaders(Arrays.asList("Authorization", "Content-type"));
      config.setAllowCredentials(true);

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", config);

      return source;

   }

   @Bean
   FilterRegistrationBean<CorsFilter> corsFilter() {
      FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(this.configurationSource()));
      corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

      return corsBean;
   }

}
