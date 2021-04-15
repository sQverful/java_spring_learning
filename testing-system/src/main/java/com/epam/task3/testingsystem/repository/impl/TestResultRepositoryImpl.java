package com.epam.task3.testingsystem.repository.impl;

import com.epam.task3.testingsystem.model.TestResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestResultRepositoryImpl implements com.epam.task3.testingsystem.repository.TestResultRepository {

    private List<TestResult> list = new ArrayList<>();

    @Override
    public TestResult getTestResult(int id) {
        return list.stream()
                .filter(testResult -> testResult.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public TestResult createTestResult(TestResult testResult) {
        list.add(testResult);
        return testResult;
    }

    @Override
    public TestResult updateTestResult(int id, TestResult testResult) {
        boolean isDeleted = list.removeIf(ts -> ts.getId() == id);
        if (isDeleted) {
            list.add(testResult);
        } else {
            throw new RuntimeException("TestDto does not exists!!!");
        }
        return testResult;
    }

    @Override
    public void deleteTestResult(int id) {
        list.removeIf(testResult -> testResult.getId() == id);
    }
}
