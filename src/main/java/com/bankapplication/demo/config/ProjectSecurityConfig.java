package com.bankapplication.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    public static final String[] NOT_PERMITTED_REQUESTS = {"/myAccount", "/myBalance", "/myLoans", "/myCards"};
    public static final String[] PERMITTED_REQUESTS = {"/notices", "/contact"};

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((requests) -> {
                    requests.requestMatchers(NOT_PERMITTED_REQUESTS).authenticated();
                    requests.requestMatchers(PERMITTED_REQUESTS).permitAll();
                })
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();

    }

}
