package com.example.umc88;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc88Application {

    public static void main(String[] args) {
        SpringApplication.run(Umc88Application.class, args);
    }

}
