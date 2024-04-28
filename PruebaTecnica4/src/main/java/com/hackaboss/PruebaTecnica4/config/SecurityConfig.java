package com.hackaboss.PruebaTecnica4.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableAutoConfiguration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/agency/flights/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/agency/hotels/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/agency/persons/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/agency/persons/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/agency/hotel-booking/new").permitAll()
                .requestMatchers(HttpMethod.POST, "/agency/flight-booking/new").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .build();
    }

}
