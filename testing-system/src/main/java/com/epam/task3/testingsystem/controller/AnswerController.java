package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.AnswerAssembler;
import com.epam.task3.testingsystem.controller.model.AnswerModel;
import com.epam.task3.testingsystem.dto.AnswerDto;
import com.epam.task3.testingsystem.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerAssembler answerAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public AnswerModel getAnswer(@PathVariable int id) {
        AnswerDto answerDto = answerService.getAnswer(id);
        log.info("Get answer: {}", answerDto);
        return answerAssembler.toModel(answerDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AnswerModel createAnswer(@Valid @RequestBody AnswerDto answerDto) {
        AnswerDto createdAnswer = answerService.createAnswer(answerDto);
        log.info("Create answer: {}", answerDto);
        return answerAssembler.toModel(createdAnswer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public AnswerModel updateAnswer(@PathVariable int id, @RequestBody AnswerDto answerDto) {
        AnswerDto answerDtoAfter = answerService.updateAnswer(id, answerDto);
        log.info("Update answer: {}", answerDtoAfter);
        return answerAssembler.toModel(answerDtoAfter);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAnswer(@PathVariable int id) {
        log.info("Delete answer: {}", answerService.getAnswer(id));
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
