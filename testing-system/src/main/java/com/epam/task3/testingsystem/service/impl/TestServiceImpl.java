package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.TestDto;
import com.epam.task3.testingsystem.model.Test;
import com.epam.task3.testingsystem.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements com.epam.task3.testingsystem.service.TestService {

    private final TestRepository testRepository;

    @Override
    public TestDto getTest(int id) {
        Test test = testRepository.getTest(id);
        return mapTestToTestDto(test);
    }

    @Override
    public TestDto createTest(TestDto testDto) {
        Test test = mapTestDtoToTest(testDto);
        testRepository.createTest(test);
        return mapTestToTestDto(test);
    }

    @Override
    public TestDto updateTest(int id, TestDto testDto) {
        Test test = testRepository.updateTest(id, mapTestDtoToTest(testDto));
        return mapTestToTestDto(test);
    }

    @Override
    public void deleteTest(int id) {
        testRepository.deleteTest(id);
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
