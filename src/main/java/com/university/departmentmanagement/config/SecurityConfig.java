package com.university.departmentmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Вимкнення CSRF для тестів
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // Дозволити доступ до всіх ресурсів
                );

        return http.build();
    }
}
