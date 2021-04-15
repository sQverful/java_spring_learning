package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.QuestionDto;
import com.epam.task3.testingsystem.model.Question;
import com.epam.task3.testingsystem.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements com.epam.task3.testingsystem.service.QuestionService {

    private QuestionRepository questionRepository;

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
        return QuestionDto.builder()
                .id(question.getId())
                .questionEN(question.getQuestionEN())
                .questionUA(question.getQuestionUA())
                .testId(question.getTestId())
                .build();
    }

    private Question mapQuestionDtoToQuestion(QuestionDto questionDto) {
        return Question.builder()
                .id(questionDto.getId())
                .questionEN(questionDto.getQuestionEN())
                .questionUA(questionDto.getQuestionUA())
                .testId(questionDto.getTestId())
                .build();
    }
}
