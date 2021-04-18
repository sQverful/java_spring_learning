package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.QuestionAssembler;
import com.epam.task3.testingsystem.controller.model.QuestionModel;
import com.epam.task3.testingsystem.dto.QuestionDto;
import com.epam.task3.testingsystem.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionAssembler questionAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public QuestionModel getQuestion(@PathVariable int id) {
        QuestionDto questionDto = questionService.getQuestion(id);
        log.info("Get question: {}", questionDto);
        return questionAssembler.toModel(questionDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public QuestionModel createQuestion(@Valid @RequestBody QuestionDto questionDto) {
        QuestionDto createdQuestion = questionService.createQuestion(questionDto);
        log.info("Create question: {}", questionDto);
        return questionAssembler.toModel(createdQuestion);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public QuestionModel updateQuestion(@PathVariable int id, @RequestBody QuestionDto questionDto) {
        QuestionDto questionDtoAfter = questionService.updateQuestion(id, questionDto);
        log.info("Update question: {}", questionDtoAfter);
        return questionAssembler.toModel(questionDtoAfter);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteQuestion(@PathVariable int id) {
        log.info("Delete question: {}", questionService.getQuestion(id));
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

}
