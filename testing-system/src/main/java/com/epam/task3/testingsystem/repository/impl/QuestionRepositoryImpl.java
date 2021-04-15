package com.epam.task3.testingsystem.repository.impl;

import com.epam.task3.testingsystem.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionRepositoryImpl implements com.epam.task3.testingsystem.repository.QuestionRepository {

    List<Question> list = new ArrayList<>();

    @Override
    public Question createQuestion(Question question) {
        list.add(question);
        return question;
    }

    @Override
    public Question getQuestion(int id) {
        return list.stream()
                .filter(question -> question.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Question updateQuestion(int id, Question question) {
        boolean isDeleted = list.removeIf(q -> q.getId() == id);
        if (isDeleted) {
            list.add(question);
        } else {
            throw new RuntimeException("Subject does not exists!");
        }
        return question;
    }

    @Override
    public void deleteQuestion(int id) {
        list.removeIf(question -> question.getId() == id);
    }

    @Override
    public List<Question> getList() {
        return list;
    }
}
