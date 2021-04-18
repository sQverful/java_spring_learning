package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.TestAssembler;
import com.epam.task3.testingsystem.controller.model.TestModel;
import com.epam.task3.testingsystem.dto.TestDto;
import com.epam.task3.testingsystem.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;

@Slf4j
@RequestMapping("/tests")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    private final TestAssembler testAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public TestModel getTest(@PathVariable int id) {
        TestDto testDto = testService.getTest(id);
        log.info("Get test: {}", testDto);
        return testAssembler.toModel(testDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TestModel createTest(@Valid @RequestBody TestDto testDto) {
        testDto.setCreatedOn(new Timestamp(System.currentTimeMillis()));
        TestDto createdTest = testService.createTest(testDto);
        log.info("Create test: {}", testDto);
        return testAssembler.toModel(createdTest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public TestModel updateTest(@PathVariable int id, @RequestBody TestDto testDto) {
        TestDto testDtoAfter = testService.updateTest(id, testDto);
        log.info("Update test: {}", testDtoAfter);
        return testAssembler.toModel(testDtoAfter);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTest(@PathVariable int id) {
        log.info("Delete test: {}", testService.getTest(id));
        testService.deleteTest(id);
        return ResponseEntity.noContent().build();
    }
}
