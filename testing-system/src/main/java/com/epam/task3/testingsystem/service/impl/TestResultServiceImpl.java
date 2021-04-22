package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.TestResultDto;
import com.epam.task3.testingsystem.model.TestResult;
import com.epam.task3.testingsystem.repository.TestResultRepository;
import com.epam.task3.testingsystem.service.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;

    @Override
    public TestResultDto getTestResult(int id) {
        TestResult testResult = testResultRepository.getTestResult(id);
        return mapTestResultToTestResultDto(testResult);
    }

    @Override
    public TestResultDto createTestResult(TestResultDto testResultDto) {
        TestResult testResult = mapTestResultDtoToTestResult(testResultDto);
        testResultRepository.createTestResult(testResult);
        return mapTestResultToTestResultDto(testResult);
    }

    @Override
    public TestResultDto updateTestResult(int id, TestResultDto testResultDto) {
        TestResult testResult = testResultRepository.updateTestResult(id, mapTestResultDtoToTestResult(testResultDto));
        return mapTestResultToTestResultDto(testResult);
    }

    @Override
    public void deleteTestResult(int id) {
        testResultRepository.deleteTestResult(id);
    }

    private TestResultDto mapTestResultToTestResultDto(TestResult testResult) {
        TestResultDto testResultDto = TestResultDto.builder().build();
        BeanUtils.copyProperties(testResult, testResultDto);
        return testResultDto;
    }

    private TestResult mapTestResultDtoToTestResult(TestResultDto testResultDto) {
        TestResult testResult = TestResult.builder().build();
        BeanUtils.copyProperties(testResultDto, testResult);
        return testResult;
    }
}
