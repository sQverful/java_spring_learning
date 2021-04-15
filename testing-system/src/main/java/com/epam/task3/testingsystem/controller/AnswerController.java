package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.dto.AnswerDto;
import com.epam.task3.testingsystem.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public AnswerDto getAnswer(@PathVariable int id) {
        AnswerDto answerDto = answerService.getAnswer(id);
        log.info("Get answer: {}", answerDto);
        return answerDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AnswerDto createAnswer(@RequestBody AnswerDto answerDto) {
        log.info("Create answer: {}", answerDto);
        return answerService.createAnswer(answerDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public AnswerDto updateUser(@PathVariable int id, @RequestBody AnswerDto answerDto) {
        AnswerDto answerDtoAfter = answerService.updateAnswer(id, answerDto);
        log.info("Update answer: {}", answerDtoAfter);
        return answerDtoAfter;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAnswer(@PathVariable int id) {
        log.info("Delete answer: {}", answerService.getAnswer(id));
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
