package com.epam.task3.testingsystem.controller.assembler;

import com.epam.task3.testingsystem.controller.TestController;
import com.epam.task3.testingsystem.controller.model.TestModel;
import com.epam.task3.testingsystem.dto.TestDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TestAssembler extends RepresentationModelAssemblerSupport<TestDto, TestModel> {

    public TestAssembler() {
        super(TestAssembler.class, TestModel.class);
    }
    @Override
    public TestModel toModel(TestDto entity) {
        TestModel testModel = new TestModel(entity);

        Link getTest = linkTo(methodOn(TestController.class).getTest(entity.getId()))
                .withRel("getTest");
        Link deleteTest = linkTo(methodOn(TestController.class).deleteTest(entity.getId()))
                .withRel("deleteTest");
        Link updateTest = linkTo(methodOn(TestController.class).updateTest(entity.getId(), entity))
                .withRel("updateTest");

        testModel.add(getTest, deleteTest, updateTest);

        return testModel;
    }
}
