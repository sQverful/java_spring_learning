package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.TestDto;
import com.epam.task3.testingsystem.exception.EntityNotFoundException;
import com.epam.task3.testingsystem.model.Test;
import com.epam.task3.testingsystem.repository.TestRepository;
import com.epam.task3.testingsystem.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public List<TestDto> getTestList() {
        log.info("getting test list from database");
        List<Test> testList = testRepository.findAll();
        return testList.stream()
                .map(this::mapTestToTestDto)
                .collect(Collectors.toList());
    }

    @Override
    public TestDto getTest(int id) {
        log.info("getting test from database {}", id);
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestNotFound in DB!"));
        return mapTestToTestDto(test);
    }

    @Override
    public TestDto createTest(TestDto testDto) {
        log.info("creating test in database {}", testDto);
        Test test = mapTestDtoToTest(testDto);
        testRepository.save(test);
        return mapTestToTestDto(test);
    }

    @Override
    public TestDto updateTest(int id, TestDto testDto) {
        log.info("updating test in database: {}", testDto);
        testDto.setId(id);
        Test test = mapTestDtoToTest(testDto);
        Test testFromDB = testRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestNotFound in DB!"));
//        testRepository.delete(testFromDB);
        test = testRepository.save(test);
        return mapTestToTestDto(test);
    }

    @Override
    public TestDto partialUpdateTest(int id, TestDto testDto) {
        log.info("partial updating test in database: {}", testDto);
        testDto.setId(id);
        Test test = mapTestDtoToTest(testDto);
        Test testFromDB = testRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestNotFound in DB!"));
        test = testRepository.save(test);
        return mapTestToTestDto(test);
    }

    @Override
    public void deleteTest(int id) {
        log.info("deleting test in database by id: {}", id);
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestNotFound in DB!"));
        testRepository.delete(test);
    }

    @Override
    public TestDto incrementRequestsQuantity(int id) {
        log.info("incrementing requestsQuantity in test in database by id: {}", id);
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestNotFound in DB!"));
        test.setRequestsQuantity(test.getRequestsQuantity() + 1);
        test = testRepository.save(test);
        return mapTestToTestDto(test);
    }

    private TestDto mapTestToTestDto(Test test) {
        TestDto testDto = TestDto.builder().build();
        BeanUtils.copyProperties(test, testDto);
        return testDto;
    }

    private Test mapTestDtoToTest(TestDto testDto) {
        Test test = Test.builder().build();
        BeanUtils.copyProperties(testDto, test);
        return test;
    }

}
