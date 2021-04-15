package com.epam.task3.testingsystem.repository;

import com.epam.task3.testingsystem.model.TestResult;

public interface TestResultRepository {
    TestResult getTestResult(int id);

    TestResult createTestResult(TestResult testResult);

    TestResult updateTestResult(int id, TestResult testResult);

    void deleteTestResult(int id);
}
