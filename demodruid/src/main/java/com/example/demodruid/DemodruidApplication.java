package com.example.demodruid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemodruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemodruidApplication.class, args);
    }

}
