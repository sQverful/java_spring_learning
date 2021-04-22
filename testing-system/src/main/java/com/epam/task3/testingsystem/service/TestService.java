package com.epam.task3.testingsystem.service;

import com.epam.task3.testingsystem.dto.TestDto;

import java.util.List;

public interface TestService {
    List<TestDto> getTestList();

    TestDto getTest(int id);

    TestDto createTest(TestDto testDto);

    TestDto updateTest(int id, TestDto testDto);

    TestDto partialUpdateTest(int id, TestDto testDto);

    void deleteTest(int id);

    TestDto incrementRequestsQuantity(int id);
}
