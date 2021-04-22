package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.TestAssembler;
import com.epam.task3.testingsystem.controller.model.TestModel;
import com.epam.task3.testingsystem.dto.TestDto;
import com.epam.task3.testingsystem.service.TestService;
import com.epam.task3.testingsystem.swaggerApi.TestApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController implements TestApi {

    private final TestService testService;
    private final TestAssembler testAssembler;

    @Override
    public CollectionModel<TestModel> getTestList() {
        log.info("Get test list");
        List<TestModel> testModelList = testService.getTestList().stream()
                .map(testAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(testModelList, linkTo(methodOn(TestController.class).getTestList()).withSelfRel());
    }

    @Override
    public TestModel getTest(int id) {
        TestDto testDto = testService.getTest(id);
        testService.incrementRequestsQuantity(id);
        log.info("Get test: {}", testDto);
        return testAssembler.toModel(testDto);
    }

    @Override
    public TestModel createTest(TestDto testDto) {
        TestDto createdTest = testService.createTest(testDto);
        log.info("Create test: {}", testDto);
        return testAssembler.toModel(createdTest);
    }

    @Override
    public TestModel updateTest(int id, TestDto testDto) {
        TestDto testDtoAfter = testService.updateTest(id, testDto);
        log.info("Update test: {}", testDtoAfter);
        return testAssembler.toModel(testDtoAfter);
    }

    @Override
    public TestModel partialUpdateTest(int id, TestDto testDto) {
        TestDto testDtoAfter = testService.partialUpdateTest(id, testDto);
        log.info("Partial update test: {}", testDtoAfter);
        return testAssembler.toModel(testDtoAfter);    }


    @Override
    public ResponseEntity<Void> deleteTest(int id) {
        log.info("Delete test: {}", testService.getTest(id));
        testService.deleteTest(id);
        return ResponseEntity.noContent().build();
    }
}
