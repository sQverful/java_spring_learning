package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.TestResultDto;
import com.epam.task3.testingsystem.model.TestResult;
import com.epam.task3.testingsystem.repository.TestResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestResultServiceImpl implements com.epam.task3.testingsystem.service.TestResultService {

    private TestResultRepository testResultRepository;

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
        return TestResultDto.builder()
                .id(testResult.getId())
                .result(testResult.getResult())
                .userId(testResult.getUserId())
                .testId(testResult.getTestId())
                .createdOn(testResult.getCreatedOn())
                .build();
    }

    private TestResult mapTestResultDtoToTestResult(TestResultDto testResultDto) {
        return TestResult.builder()
                .id(testResultDto.getId())
                .result(testResultDto.getResult())
                .userId(testResultDto.getUserId())
                .testId(testResultDto.getTestId())
                .createdOn(testResultDto.getCreatedOn())
                .build();
    }
}
