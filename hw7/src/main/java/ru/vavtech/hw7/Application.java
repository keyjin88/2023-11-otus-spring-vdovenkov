package ru.vavtech.hw7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan("ru.vavtech.hw7.commands")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
