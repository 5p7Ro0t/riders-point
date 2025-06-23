package com.riderspoint.auth_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // Allow OTP/login endpoints
                .anyRequest().authenticated() // All others require JWT
            )
            .httpBasic().disable() // 🚫 Disable default Basic Auth
            .formLogin().disable(); // 🚫 Disable form login UI

        return http.build();
    }
}
