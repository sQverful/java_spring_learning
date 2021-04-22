package com.epam.task3.testingsystem.swaggerApi;

import com.epam.task3.testingsystem.controller.model.TestModel;
import com.epam.task3.testingsystem.dto.TestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Test management API")
@RequestMapping("/api/v1/tests")
public interface TestApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Test id"),
    })

    @ApiOperation("Get test list")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    CollectionModel<TestModel> getTestList();

    @ApiOperation("Get test")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    TestModel getTest(@PathVariable int id);

    @ApiOperation("Create test")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TestModel createTest(@Valid @RequestBody TestDto testDto);

    @ApiOperation("Update test")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    TestModel updateTest(@PathVariable int id, @RequestBody TestDto testDto);

    @ApiOperation("Update test")
    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(value = "/{id}")
    TestModel partialUpdateTest(@PathVariable int id, @RequestBody TestDto testDto);

    @ApiOperation("Delete test")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTest(@PathVariable int id);
}
