package ru.vavtech.hw3.dao;


import ru.vavtech.hw3.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
