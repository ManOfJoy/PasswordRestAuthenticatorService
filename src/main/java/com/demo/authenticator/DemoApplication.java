package com.demo.authenticator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot Application for Password Authentication Demo
 * 
 * @author Manoj 09/14/2018
 * 
 */
@SpringBootApplication
@ComponentScan("com.demo")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
}
