package ru.vavtech.hw3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vavtech.hw3.domain.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final IOService ioService;

    @Override
    public Student determineCurrentStudent() {
        var firstName = ioService.readStringWithPrompt("first.name.request");
        var lastName = ioService.readStringWithPrompt("last.name.request");
        return new Student(firstName, lastName);
    }
}
