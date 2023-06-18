package com.example.gofmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GoFMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoFMavenApplication.class, args);
    }

}
