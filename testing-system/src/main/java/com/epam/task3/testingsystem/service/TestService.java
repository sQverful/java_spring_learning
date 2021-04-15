package com.epam.task3.testingsystem.service;

import com.epam.task3.testingsystem.dto.TestDto;

public interface TestService {
    TestDto getTest(int id);

    TestDto createTest(TestDto testDto);

    TestDto updateTest(int id, TestDto testDto);

    void deleteTest(int id);
}
