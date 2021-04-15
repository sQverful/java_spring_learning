package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.dto.TestDto;
import com.epam.task3.testingsystem.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/tests")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public TestDto getTest(@PathVariable int id) {
        TestDto testDto = testService.getTest(id);
        log.info("Get test: {}", testDto);
        return testDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TestDto createTest(@RequestBody TestDto testDto) {
        log.info("Create test: {}", testDto);
        return testService.createTest(testDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public TestDto updateTest(@PathVariable int id, @RequestBody TestDto testDto) {
        TestDto testDtoAfter = testService.updateTest(id, testDto);
        log.info("Update test: {}", testDtoAfter);
        return testDtoAfter;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        log.info("Delete test: {}", testService.getTest(id));
        testService.deleteTest(id);
        return ResponseEntity.noContent().build();
    }
}
