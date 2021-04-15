package com.epam.task3.testingsystem.service;

import com.epam.task3.testingsystem.dto.QuestionDto;

public interface QuestionService {
    QuestionDto getQuestion(int id);

    QuestionDto createQuestion(QuestionDto questionDto);

    QuestionDto updateQuestion(int id, QuestionDto questionDto);

    void deleteQuestion(int id);
}
