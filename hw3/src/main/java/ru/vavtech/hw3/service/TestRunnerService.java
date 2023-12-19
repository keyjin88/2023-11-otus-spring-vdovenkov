package ru.vavtech.hw3.service;

import org.springframework.boot.CommandLineRunner;

public interface TestRunnerService extends CommandLineRunner {
    void run(String... args);
}
