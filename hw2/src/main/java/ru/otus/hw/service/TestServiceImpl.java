package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Student;
import ru.otus.hw.domain.TestResult;

import java.util.List;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        for (int i = 0; i < questions.size(); i++) {
            var question = questions.get(i);
            var isAnswerValid = false;
            ioService.printFormattedLine("Question %d: %s", i, question.text());
            List<Answer> answers = question.answers();
            for (int j = 0; j < answers.size(); j++) {
                Answer answer = answers.get(j);
                ioService.printFormattedLine("%d) %s", j, answer.text());
            }
            var answer = ioService.readIntForRangeWithPrompt(
                    0,
                    question.answers().size(),
                    "Enter answer number: ",
                    "Answer must be from 0 to %d".formatted(question.answers().size() - 1));
            isAnswerValid = question.answers().get(answer).isCorrect();
            testResult.applyAnswer(question, isAnswerValid);
        }
        return testResult;
    }
}
