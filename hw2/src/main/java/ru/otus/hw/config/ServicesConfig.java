package ru.otus.hw.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.service.IOService;
import ru.otus.hw.service.ResultService;
import ru.otus.hw.service.ResultServiceImpl;
import ru.otus.hw.service.StreamsIOService;
import ru.otus.hw.service.StudentService;
import ru.otus.hw.service.StudentServiceImpl;
import ru.otus.hw.service.TestRunnerService;
import ru.otus.hw.service.TestRunnerServiceImpl;
import ru.otus.hw.service.TestService;
import ru.otus.hw.service.TestServiceImpl;

@Configuration
public class ServicesConfig {

    @Bean
    public IOService ioService() {
        return new StreamsIOService(java.lang.System.out, java.lang.System.in);
    }

    @Bean
    public TestService testService(@Qualifier("ioService") IOService ioService,
                                   @Qualifier("questionDao") QuestionDao questionDao) {
        return new TestServiceImpl(ioService, questionDao);
    }

    @Bean
    public StudentService studentService(@Qualifier("ioService") IOService ioService) {
        return new StudentServiceImpl(ioService);
    }

    @Bean
    public ResultService resultService(AppProperties appProperties, @Qualifier("ioService") IOService ioService) {
        return new ResultServiceImpl(appProperties, ioService);
    }

    @Bean
    public TestRunnerService personService(@Qualifier("testService") TestService testService,
                                           @Qualifier("studentService") StudentService studentService,
                                           @Qualifier("resultService") ResultService resultService) {
        return new TestRunnerServiceImpl(testService, studentService, resultService);
    }
}
