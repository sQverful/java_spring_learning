package com.epam.task3.testingsystem.controller.assembler;

import com.epam.task3.testingsystem.controller.TestResultsController;
import com.epam.task3.testingsystem.controller.model.TestResultsModel;
import com.epam.task3.testingsystem.dto.TestResultDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TestResultsAssembler extends RepresentationModelAssemblerSupport<TestResultDto, TestResultsModel> {

    public TestResultsAssembler() {
        super(TestResultsAssembler.class, TestResultsModel.class);
    }

    @Override
    public TestResultsModel toModel(TestResultDto entity) {
        TestResultsModel testResultsModel = new TestResultsModel(entity);

        Link getTR = linkTo(methodOn(TestResultsController.class).getTestResult(entity.getId()))
                .withRel("getTestResult");
        Link deleteTR = linkTo(methodOn(TestResultsController.class).deleteTestResult(entity.getId()))
                .withRel("deleteTestResult");
        Link updateTR = linkTo(methodOn(TestResultsController.class).updateTestResult(entity.getId(), entity))
                .withRel("updateTestResult");

        testResultsModel.add(getTR, deleteTR, updateTR);

        return testResultsModel;
    }
}
