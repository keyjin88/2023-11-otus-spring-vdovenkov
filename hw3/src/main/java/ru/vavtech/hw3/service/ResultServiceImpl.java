package ru.vavtech.hw3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vavtech.hw3.config.TestConfig;
import ru.vavtech.hw3.domain.TestResult;


@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final TestConfig testConfig;

    private final IOService ioService;

    @Override
    public void showResult(TestResult testResult) {
        ioService.printLine("empty.message");
        ioService.printLine("test.results");
        ioService.printFormattedLine("student.name", testResult.getStudent().getFullName());
        ioService.printFormattedLine("answered.question.count", testResult.getAnsweredQuestions().size());
        ioService.printFormattedLine("right.answers.count", testResult.getRightAnswersCount());

        if (testResult.getRightAnswersCount() >= testConfig.getRightAnswersCountToPass()) {
            ioService.printLine("test.passed");
            return;
        }
        ioService.printLine("test.failed");
    }
}
