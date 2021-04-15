package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.dto.QuestionDto;
import com.epam.task3.testingsystem.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public QuestionDto getAnswer(@PathVariable int id) {
        QuestionDto questionDto = questionService.getQuestion(id);
        log.info("Get question: {}", questionDto);
        return questionDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public QuestionDto createQuestion(@RequestBody QuestionDto questionDto) {
        log.info("Create question: {}", questionDto);
        return questionService.createQuestion(questionDto);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public QuestionDto updateQuestion(@PathVariable int id, @RequestBody QuestionDto questionDto) {
        QuestionDto questionDtoAfter = questionService.updateQuestion(id, questionDto);
        log.info("Update question: {}", questionDtoAfter);
        return questionDtoAfter;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteQuestion(@PathVariable int id) {
        log.info("Delete question: {}", questionService.getQuestion(id));
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

}
