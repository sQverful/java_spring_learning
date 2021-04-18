package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.TestResultsAssembler;
import com.epam.task3.testingsystem.controller.model.TestResultsModel;
import com.epam.task3.testingsystem.dto.TestResultDto;
import com.epam.task3.testingsystem.service.TestResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/testResults")
@RestController
@RequiredArgsConstructor
public class TestResultsController {

    private final TestResultService tsService;
    private final TestResultsAssembler testResultsAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")

    public TestResultsModel getTestResult(@PathVariable int id) {
        TestResultDto testResultDto = tsService.getTestResult(id);
        log.info("Get testResult: {}", testResultDto);
        return testResultsAssembler.toModel(testResultDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TestResultsModel createTestResult(@Valid @RequestBody TestResultDto testResultDto) {
        TestResultDto testResultDto1 = tsService.createTestResult(testResultDto);
        log.info("Create testResult: {}", testResultDto);
        return testResultsAssembler.toModel(testResultDto1);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public TestResultsModel updateTestResult(@PathVariable int id, @RequestBody TestResultDto testResultDto) {
        TestResultDto tsAfterUpdate = tsService.updateTestResult(id, testResultDto);
        log.info("Update user: {}", tsAfterUpdate);
        return testResultsAssembler.toModel(tsAfterUpdate);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTestResult(@PathVariable int id) {
        log.info("Delete testResult: {}", tsService.getTestResult(id));
        tsService.deleteTestResult(id);
        return ResponseEntity.noContent().build();
    }
}
