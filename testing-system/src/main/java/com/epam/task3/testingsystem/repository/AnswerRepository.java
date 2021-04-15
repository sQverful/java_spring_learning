package com.epam.task3.testingsystem.repository;

import com.epam.task3.testingsystem.model.Answer;

public interface AnswerRepository {
    Answer getAnswer(int id);

    Answer createAnswer(Answer answer);

    Answer updateAnswer(int id, Answer answer);

    void deleteAnswer(int id);
}
