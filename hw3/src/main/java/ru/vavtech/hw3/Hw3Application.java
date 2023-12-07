package ru.vavtech.hw3;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vavtech.hw3.service.TestRunnerService;

@SpringBootApplication
public class Hw3Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw3Application.class, args);
    }

}
