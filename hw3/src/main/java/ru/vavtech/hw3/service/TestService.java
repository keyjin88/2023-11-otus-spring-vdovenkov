package ru.vavtech.hw3.service;


import ru.vavtech.hw3.domain.Student;
import ru.vavtech.hw3.domain.TestResult;

public interface TestService {

    TestResult executeTestFor(Student student);
}
