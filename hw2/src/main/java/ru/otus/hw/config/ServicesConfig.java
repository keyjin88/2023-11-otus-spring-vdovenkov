package ru.otus.hw.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.service.IOService;
import ru.otus.hw.service.StreamsIOService;
import ru.otus.hw.service.TestRunnerService;
import ru.otus.hw.service.TestRunnerServiceImpl;
import ru.otus.hw.service.TestService;
import ru.otus.hw.service.TestServiceImpl;

@Configuration
public class ServicesConfig {

    @Bean
    public IOService ioService() {
        return new StreamsIOService(java.lang.System.out);
    }

    @Bean
    public TestService testService(@Qualifier("ioService") IOService ioService,
                                   @Qualifier("questionDao") QuestionDao questionDao) {
        return new TestServiceImpl(ioService, questionDao);
    }

    @Bean
    public TestRunnerService personService(@Qualifier("testService") TestService testService) {
        return new TestRunnerServiceImpl(testService);
    }
}
