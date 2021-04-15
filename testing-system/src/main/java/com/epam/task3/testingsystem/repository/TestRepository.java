package com.epam.task3.testingsystem.repository;

import com.epam.task3.testingsystem.model.Test;

import java.util.List;

public interface TestRepository {
    Test createTest(Test test);

    Test getTest(int id);

    Test updateTest(int id, Test test);

    void deleteTest(int id);

    List<Test> getTestList();
}
