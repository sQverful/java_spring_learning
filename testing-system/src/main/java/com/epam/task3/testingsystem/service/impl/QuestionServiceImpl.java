package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.QuestionDto;
import com.epam.task3.testingsystem.exception.EntityNotFoundException;
import com.epam.task3.testingsystem.model.Question;
import com.epam.task3.testingsystem.repository.QuestionRepository;
import com.epam.task3.testingsystem.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private static final String DEFAULT_ERROR_MESSAGE = "Question not found in DB!";

    @Override
    public List<QuestionDto> getQuestionList() {
        log.info("getting question list from database");
        return questionRepository.findAll()
                .stream()
                .map(question -> mapQuestionToQuestionDto(question))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDto getQuestion(int id) {
        log.info("getting question from database {}", id);
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
        return mapQuestionToQuestionDto(question);
    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        log.info("creating question in database {}", questionDto);
        Question question = mapQuestionDtoToQuestion(questionDto);
        questionRepository.save(question);
        return mapQuestionToQuestionDto(question);
    }

    @Override
    public QuestionDto updateQuestion(int id, QuestionDto questionDto) {
        log.info("updating question in database {} with id {}", questionDto, id);
        questionDto.setId(id);
        Question question = mapQuestionDtoToQuestion(questionDto);
        Question questionFromDB = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
        question = questionRepository.save(question);
        return mapQuestionToQuestionDto(question);
    }

    @Override
    public void deleteQuestion(int id) {
        log.info("deleting question in database with id {}", id);
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
        questionRepository.delete(question);
    }

    private QuestionDto mapQuestionToQuestionDto(Question question) {
        QuestionDto questionDto = QuestionDto.builder().build();
        BeanUtils.copyProperties(question, questionDto);
        return questionDto;
    }

    private Question mapQuestionDtoToQuestion(QuestionDto questionDto) {
        Question question = Question.builder().build();
        BeanUtils.copyProperties(questionDto, question);
        return question;
    }
}
