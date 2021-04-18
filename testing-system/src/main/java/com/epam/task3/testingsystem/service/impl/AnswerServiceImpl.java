package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.AnswerDto;
import com.epam.task3.testingsystem.model.Answer;
import com.epam.task3.testingsystem.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements com.epam.task3.testingsystem.service.AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public AnswerDto getAnswer(int id) {
        Answer answer = answerRepository.getAnswer(id);
        return mapAnswerToAnswerDto(answer);
    }

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        Answer answer = mapAnswerDtoToAnswer(answerDto);
        answerRepository.createAnswer(answer);
        return mapAnswerToAnswerDto(answer);
    }

    @Override
    public AnswerDto updateAnswer(int id, AnswerDto answerDto) {
        Answer answer = answerRepository.updateAnswer(id, mapAnswerDtoToAnswer(answerDto));
        return mapAnswerToAnswerDto(answer);
    }

    @Override
    public void deleteAnswer(int id) {
        answerRepository.deleteAnswer(id);
    }

    private AnswerDto mapAnswerToAnswerDto(Answer answer) {
        AnswerDto answerDto = AnswerDto.builder().build();
        BeanUtils.copyProperties(answer, answerDto);
        return answerDto;
    }

    private Answer mapAnswerDtoToAnswer(AnswerDto answerDto) {
        Answer answer = Answer.builder().build();
        BeanUtils.copyProperties(answerDto, answer);
        return answer;
    }
}
