package com.epam.task3.testingsystem.repository.impl;

import com.epam.task3.testingsystem.model.Test;
import com.epam.task3.testingsystem.repository.TestRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestRepositoryImpl implements TestRepository {

    private List<Test> testList = new ArrayList<>();

    @Override
    public Test createTest(Test test) {
        testList.add(test);
        return test;
    }

    @Override
    public Test getTest(int id) {
        return testList.stream()
                .filter(test -> test.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Test updateTest(int id, Test test) {
        boolean isDeleted = testList.removeIf(t -> t.getId() == id);
        if (isDeleted) {
            testList.add(test);
        } else {
            throw new RuntimeException("Test does not exists!");
        }
        return test;
    }

    @Override
    public void deleteTest(int id) {
        testList.removeIf(test -> test.getId() == id);
    }

    @Override
    public List<Test> getTestList() {
        return testList;
    }
}
