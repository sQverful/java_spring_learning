package com.epam.task3.testingsystem.controller.assembler;

import com.epam.task3.testingsystem.controller.QuestionController;
import com.epam.task3.testingsystem.controller.model.QuestionModel;
import com.epam.task3.testingsystem.dto.QuestionDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class QuestionAssembler extends RepresentationModelAssemblerSupport<QuestionDto, QuestionModel> {

    public QuestionAssembler() {
        super(QuestionAssembler.class, QuestionModel.class);
    }

    @Override
    public QuestionModel toModel(QuestionDto entity) {
        QuestionModel questionModel = new QuestionModel(entity);

        Link getQuestion = linkTo(methodOn(QuestionController.class).getQuestion(entity.getId()))
                .withRel("getQuestion");
        Link deleteQuestion = linkTo(methodOn(QuestionController.class).deleteQuestion(entity.getId()))
                .withRel("deleteQuestion");
        Link updateQuestion = linkTo(methodOn(QuestionController.class).updateQuestion(entity.getId(), entity))
                .withRel("updateQuestion");

        questionModel.add(getQuestion, deleteQuestion, updateQuestion);

        return questionModel;
    }
}
