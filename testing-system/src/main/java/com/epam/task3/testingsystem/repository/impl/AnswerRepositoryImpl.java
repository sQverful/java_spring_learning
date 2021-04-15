package com.epam.task3.testingsystem.repository.impl;

import com.epam.task3.testingsystem.model.Answer;
import com.epam.task3.testingsystem.model.Question;
import com.epam.task3.testingsystem.model.TestResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerRepositoryImpl implements com.epam.task3.testingsystem.repository.AnswerRepository {

    private List<Answer> list = new ArrayList<>();

    @Override
    public Answer getAnswer(int id) {
        return list.stream()
                .filter(answer -> answer.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Answer createAnswer(Answer answer) {
        list.add(answer);
        return answer;
    }

    @Override
    public Answer updateAnswer(int id, Answer answer) {
        boolean isDeleted = list.removeIf(an -> an.getId() == id);
        if (isDeleted) {
            list.add(answer);
        } else {
            throw new RuntimeException("TestDto does not exists!!!");
        }
        return answer;
    }

    @Override
    public void deleteAnswer(int id) {
        list.removeIf(answer -> answer.getId() == id);
    }
}
