package com.epam.task3.testingsystem.service;

import com.epam.task3.testingsystem.dto.AnswerDto;

import java.util.List;

public interface AnswerService {

    List<AnswerDto> getAnswerList();

    AnswerDto getAnswer(int id);

    AnswerDto createAnswer(AnswerDto answerDto);

    AnswerDto updateAnswer(int id, AnswerDto answerDto);

    void deleteAnswer(int id);
}
