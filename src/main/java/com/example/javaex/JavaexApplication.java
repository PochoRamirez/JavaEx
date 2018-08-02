package com.example.javaex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.javaex"})
@EnableJpaRepositories("com.example.javaex")
public class JavaexApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaexApplication.class, args);
    }
}
