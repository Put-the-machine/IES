package org.put_the_machine.ies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
@SpringBootApplication
@PropertySource("classpath:application.yaml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}