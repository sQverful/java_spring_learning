package com.epam.task3.testingsystem.controller.model;

import com.epam.task3.testingsystem.dto.TestResultDto;
import com.epam.task3.testingsystem.model.TestResult;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class TestResultsModel extends RepresentationModel<TestResultsModel> {

    @JsonUnwrapped
    private TestResultDto testResultDto;

}
