package com.epam.task3.testingsystem.service;

import com.epam.task3.testingsystem.dto.TestResultDto;

public interface TestResultService {
    TestResultDto getTestResult(int id);

    TestResultDto createTestResult(TestResultDto testResultDto);

    TestResultDto updateTestResult(int id, TestResultDto testResultDto);

    void deleteTestResult(int id);
}
