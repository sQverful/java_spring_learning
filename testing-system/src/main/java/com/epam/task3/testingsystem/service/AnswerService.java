package com.epam.task3.testingsystem.service;

import com.epam.task3.testingsystem.dto.AnswerDto;

public interface AnswerService {
    AnswerDto getAnswer(int id);

    AnswerDto createAnswer(AnswerDto answerDto);

    AnswerDto updateAnswer(int id, AnswerDto answerDto);

    void deleteAnswer(int id);
}
