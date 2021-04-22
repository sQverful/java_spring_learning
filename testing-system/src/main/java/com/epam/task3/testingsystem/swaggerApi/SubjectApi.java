package com.epam.task3.testingsystem.swaggerApi;

import com.epam.task3.testingsystem.controller.model.SubjectModel;
import com.epam.task3.testingsystem.dto.SubjectDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Subject management API")
@RequestMapping("api/v1/subjects")
public interface SubjectApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Test id"),
    })

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    CollectionModel<SubjectModel> getSubjectList();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    SubjectModel getSubject(@PathVariable int id);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    SubjectModel createSubject(@Valid @RequestBody SubjectDto subjectDto);

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    SubjectModel updateSubject(@PathVariable int id, @Valid @RequestBody SubjectDto subjectDto);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSubject(@PathVariable int id);
}
