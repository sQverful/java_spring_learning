package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.QuestionDto;
import com.epam.task3.testingsystem.model.Question;
import com.epam.task3.testingsystem.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements com.epam.task3.testingsystem.service.QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionDto getQuestion(int id) {
        Question question = questionRepository.getQuestion(id);
        return mapQuestionToQuestionDto(question);
    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = mapQuestionDtoToQuestion(questionDto);
        questionRepository.createQuestion(question);
        return mapQuestionToQuestionDto(question);
    }

    @Override
    public QuestionDto updateQuestion(int id, QuestionDto questionDto) {
        Question question = questionRepository.updateQuestion(id, mapQuestionDtoToQuestion(questionDto));
        return mapQuestionToQuestionDto(question);
    }

    @Override
    public void deleteQuestion(int id) {
        questionRepository.deleteQuestion(id);
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
