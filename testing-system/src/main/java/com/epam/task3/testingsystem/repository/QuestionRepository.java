package com.epam.task3.testingsystem.repository;

import com.epam.task3.testingsystem.model.Question;

import java.util.List;

public interface QuestionRepository {
    Question createQuestion(Question question);

    Question getQuestion(int id);

    Question updateQuestion(int id, Question question);

    void deleteQuestion(int id);

    List<Question> getList();
}
