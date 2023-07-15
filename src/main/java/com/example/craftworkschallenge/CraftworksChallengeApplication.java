package com.example.craftworkschallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CraftworksChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CraftworksChallengeApplication.class, args);
    }

}
