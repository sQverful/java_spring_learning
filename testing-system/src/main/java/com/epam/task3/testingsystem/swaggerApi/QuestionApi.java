package com.epam.task3.testingsystem.swaggerApi;

import com.epam.task3.testingsystem.controller.model.QuestionModel;
import com.epam.task3.testingsystem.dto.QuestionDto;
import io.swagger.annotations.Api;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Question management API")
@RequestMapping("api/v1/questions")
public interface QuestionApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    CollectionModel<QuestionModel> getQuestionList();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    QuestionModel getQuestion(@PathVariable int id);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    QuestionModel createQuestion(@Valid @RequestBody QuestionDto questionDto);

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    QuestionModel updateQuestion(@PathVariable int id, @RequestBody QuestionDto questionDto);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteQuestion(@PathVariable int id);
}
