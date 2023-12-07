package ru.otus.hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw.dao.CsvQuestionDao;
import ru.otus.hw.dao.QuestionDao;

@Configuration
public class DaoConfig {

    @Bean
    public QuestionDao questionDao(AppProperties appProperties) {
        return new CsvQuestionDao(appProperties);
    }
}
