package ru.vavtech.hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.vavtech.hw3.config.AppProperties;


@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Hw3Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw3Application.class, args);
    }

}
