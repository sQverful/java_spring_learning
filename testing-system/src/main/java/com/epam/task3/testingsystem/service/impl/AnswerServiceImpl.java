package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.AnswerDto;
import com.epam.task3.testingsystem.exception.EntityNotFoundException;
import com.epam.task3.testingsystem.model.Answer;
import com.epam.task3.testingsystem.repository.AnswerRepository;
import com.epam.task3.testingsystem.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private static final String DEFAULT_ERROR_MESSAGE = "Answer not found in DB";

    @Override
    public List<AnswerDto> getAnswerList() {
        log.info("getting answer list from database");
        return answerRepository.findAll()
                .stream()
                .map(this::mapAnswerToAnswerDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDto getAnswer(int id) {
        log.info("getting answer from database {}", id);
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
        return mapAnswerToAnswerDto(answer);
    }

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        log.info("creating answer in database {}", answerDto);
        Answer answer = mapAnswerDtoToAnswer(answerDto);
        answerRepository.save(answer);
        return mapAnswerToAnswerDto(answer);
    }

    @Override
    public AnswerDto updateAnswer(int id, AnswerDto answerDto) {
        log.info("updating answer in database {} with id {}", answerDto, id);
        answerDto.setId(id);
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
//        answerRepository.delete(answer);
        answer = answerRepository.save(answer);
        return mapAnswerToAnswerDto(answer);
    }

    @Override
    public void deleteAnswer(int id) {
        log.info("deleting answer in database with id {}", id);
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
        answerRepository.delete(answer);
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
