package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.AnswerAssembler;
import com.epam.task3.testingsystem.controller.model.AnswerModel;
import com.epam.task3.testingsystem.dto.AnswerDto;
import com.epam.task3.testingsystem.service.AnswerService;
import com.epam.task3.testingsystem.swaggerApi.AnswerApi;
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
public class AnswerController implements AnswerApi {

    private final AnswerService answerService;
    private final AnswerAssembler answerAssembler;

    @Override
    public CollectionModel<AnswerModel> getAnswerList() {
        log.info("Get answer list");
        List<AnswerModel> list = answerService.getAnswerList()
                .stream()
                .map(answerAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(list, linkTo(methodOn(AnswerController.class).getAnswerList()).withSelfRel());
    }

    @Override
    public AnswerModel getAnswer(int id) {
        AnswerDto answerDto = answerService.getAnswer(id);
        log.info("Get answer: {}", answerDto);
        return answerAssembler.toModel(answerDto);
    }

    @Override
    public AnswerModel createAnswer(AnswerDto answerDto) {
        AnswerDto createdAnswer = answerService.createAnswer(answerDto);
        log.info("Create answer: {}", answerDto);
        return answerAssembler.toModel(createdAnswer);
    }

    @Override
    public AnswerModel updateAnswer(int id, AnswerDto answerDto) {
        AnswerDto answerDtoAfter = answerService.updateAnswer(id, answerDto);
        log.info("Update answer: {}", answerDtoAfter);
        return answerAssembler.toModel(answerDtoAfter);
    }


    @Override
    public ResponseEntity<Void> deleteAnswer(int id) {
        log.info("Delete answer: {}", answerService.getAnswer(id));
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
