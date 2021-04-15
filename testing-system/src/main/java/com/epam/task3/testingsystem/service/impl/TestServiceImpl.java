package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.TestDto;
import com.epam.task3.testingsystem.model.Test;
import com.epam.task3.testingsystem.repository.TestRepository;
import lombok.RequiredArgsConstructor;
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
        return TestDto.builder()
                .id(test.getId())
                .nameEN(test.getNameEN())
                .nameUA(test.getNameUA())
                .descriptionEN(test.getDescriptionEN())
                .descriptionUA(test.getDescriptionUA())
                .subjectId(test.getSubjectId())
                .blocked(test.isBlocked())
                .complexity(test.getComplexity())
                .createdOn(test.getCreatedOn())
                .requestsQuantity(test.getRequestsQuantity())
                .timer(test.getTimer())
                .build();
    }

    private Test mapTestDtoToTest(TestDto testDto) {
        return Test.builder()
                .id(testDto.getId())
                .nameEN(testDto.getNameEN())
                .nameUA(testDto.getNameUA())
                .descriptionEN(testDto.getDescriptionEN())
                .descriptionUA(testDto.getDescriptionUA())
                .subjectId(testDto.getSubjectId())
                .blocked(testDto.isBlocked())
                .complexity(testDto.getComplexity())
                .createdOn(testDto.getCreatedOn())
                .requestsQuantity(testDto.getRequestsQuantity())
                .timer(testDto.getTimer())
                .build();
    }

}
