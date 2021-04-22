package com.epam.task3.testingsystem.swaggerApi;

import com.epam.task3.testingsystem.controller.model.AnswerModel;
import com.epam.task3.testingsystem.dto.AnswerDto;
import io.swagger.annotations.Api;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Api(tags = "Answer management API")
@RequestMapping("/api/v1/answers")
public interface AnswerApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    CollectionModel<AnswerModel> getAnswerList();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    AnswerModel getAnswer(@PathVariable int id);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AnswerModel createAnswer(@Valid @RequestBody AnswerDto answerDto);

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    AnswerModel updateAnswer(@PathVariable int id, @RequestBody AnswerDto answerDto);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteAnswer(@PathVariable int id);
}
