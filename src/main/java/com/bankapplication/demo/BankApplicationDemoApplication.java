package com.bankapplication.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class BankApplicationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplicationDemoApplication.class, args);
    }

}
