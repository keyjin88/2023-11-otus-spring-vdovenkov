package ru.vavtech.hw3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vavtech.hw3.dao.QuestionDao;
import ru.vavtech.hw3.domain.Answer;
import ru.vavtech.hw3.domain.Student;
import ru.vavtech.hw3.domain.TestResult;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("empty.message");
        ioService.printFormattedLine("welcome.message");
        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        for (int i = 0; i < questions.size(); i++) {
            var question = questions.get(i);
            ioService.printFormattedLine("Question %d: %s", i, question.text());
            List<Answer> answers = question.answers();
            for (int j = 0; j < answers.size(); j++) {
                Answer answer = answers.get(j);
                ioService.printFormattedLine("%d) %s", j, answer.text());
            }
            var answerIndex = ioService.readIntForRangeWithPrompt(
                    0,
                    question.answers().size(),
                    "Enter answer number: ",
                    "Answer must be from 0 to %d".formatted(question.answers().size() - 1));
            testResult.applyAnswer(question, question.answers().get(answerIndex).isCorrect());
        }
        return testResult;
    }
}
