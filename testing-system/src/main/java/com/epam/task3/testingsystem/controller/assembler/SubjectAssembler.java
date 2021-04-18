package com.epam.task3.testingsystem.controller.assembler;

import com.epam.task3.testingsystem.controller.SubjectController;
import com.epam.task3.testingsystem.controller.model.SubjectModel;
import com.epam.task3.testingsystem.dto.SubjectDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SubjectAssembler extends RepresentationModelAssemblerSupport<SubjectDto, SubjectModel> {

    public SubjectAssembler() {
        super(SubjectAssembler.class, SubjectModel.class);
    }

    @Override
    public SubjectModel toModel(SubjectDto entity) {
        SubjectModel subjectModel = new SubjectModel(entity);

        Link getSubject = linkTo(methodOn(SubjectController.class).getSubject(entity.getId()))
                .withRel("getSubject");
        Link deleteSubject = linkTo(methodOn(SubjectController.class).deleteSubject(entity.getId()))
                .withRel("deleteSubject");
        Link updateSubject = linkTo(methodOn(SubjectController.class).updateSubject(entity.getId(), entity))
                .withRel("updateSubject");

        subjectModel.add(getSubject, deleteSubject, updateSubject);

        return subjectModel;
    }
}
