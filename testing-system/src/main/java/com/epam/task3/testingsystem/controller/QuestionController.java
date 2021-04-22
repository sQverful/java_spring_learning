package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.QuestionAssembler;
import com.epam.task3.testingsystem.controller.model.QuestionModel;
import com.epam.task3.testingsystem.dto.QuestionDto;
import com.epam.task3.testingsystem.service.QuestionService;
import com.epam.task3.testingsystem.swaggerApi.QuestionApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionController implements QuestionApi {

    private final QuestionService questionService;
    private final QuestionAssembler questionAssembler;

    @Override
    public CollectionModel<QuestionModel> getQuestionList() {
        log.info("Get question list");
        List<QuestionModel> list  = questionService.getQuestionList()
                .stream()
                .map(questionAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(list, linkTo(methodOn(QuestionController.class).getQuestionList()).withSelfRel());
    }

    @Override
    public QuestionModel getQuestion(int id) {
        QuestionDto questionDto = questionService.getQuestion(id);
        log.info("Get question: {}", questionDto);
        return questionAssembler.toModel(questionDto);
    }

    @Override
    public QuestionModel createQuestion(QuestionDto questionDto) {
        QuestionDto createdQuestion = questionService.createQuestion(questionDto);
        log.info("Create question: {}", questionDto);
        return questionAssembler.toModel(createdQuestion);
    }
    @Override
    public QuestionModel updateQuestion(int id, QuestionDto questionDto) {
        QuestionDto questionDtoAfter = questionService.updateQuestion(id, questionDto);
        log.info("Update question: {}", questionDtoAfter);
        return questionAssembler.toModel(questionDtoAfter);
    }


    @Override
    public ResponseEntity<Void> deleteQuestion(int id) {
        log.info("Delete question: {}", questionService.getQuestion(id));
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

}
