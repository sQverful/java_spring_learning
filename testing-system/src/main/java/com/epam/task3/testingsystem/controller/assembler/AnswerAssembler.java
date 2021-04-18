package com.epam.task3.testingsystem.controller.assembler;

import com.epam.task3.testingsystem.controller.AnswerController;
import com.epam.task3.testingsystem.controller.model.AnswerModel;
import com.epam.task3.testingsystem.dto.AnswerDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AnswerAssembler extends RepresentationModelAssemblerSupport<AnswerDto, AnswerModel> {

    public AnswerAssembler() {
        super(AnswerAssembler.class, AnswerModel.class);
    }

    @Override
    public AnswerModel toModel(AnswerDto entity) {
        AnswerModel answerModel = new AnswerModel(entity);

        Link getAnswer = linkTo(methodOn(AnswerController.class).getAnswer(entity.getId()))
                .withRel("getAnswer");
        Link deleteAnswer = linkTo(methodOn(AnswerController.class).deleteAnswer(entity.getId()))
                .withRel("deleteAnswer");
        Link updateAnswer = linkTo(methodOn(AnswerController.class).updateAnswer(entity.getId(), entity))
                .withRel("updateAnswer");

        answerModel.add(getAnswer, deleteAnswer, updateAnswer);

        return answerModel;
    }

}
