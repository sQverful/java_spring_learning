package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.SubjectAssembler;
import com.epam.task3.testingsystem.controller.model.SubjectModel;
import com.epam.task3.testingsystem.dto.SubjectDto;
import com.epam.task3.testingsystem.service.SubjectService;
import com.epam.task3.testingsystem.swaggerApi.SubjectApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Slf4j
@RestController
@RequiredArgsConstructor
public class SubjectController implements SubjectApi {

    private final SubjectService subjectService;
    private final SubjectAssembler subjectAssembler;

    @Override
    public CollectionModel<SubjectModel> getSubjectList() {
        log.info("Get subject list");
        List<SubjectModel> subjectList = subjectService.getSubjectList()
                .stream()
                .map(subjectAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(subjectList, linkTo(methodOn(SubjectController.class).getSubjectList()).withSelfRel());
    }

    @Override
    public SubjectModel getSubject(int id) {
        SubjectDto subjectDto = subjectService.getSubject(id);
        log.info("Get subject: {}", subjectDto);
        return subjectAssembler.toModel(subjectDto);
    }

    @Override
    public SubjectModel createSubject(SubjectDto subjectDto) {
        SubjectDto createdSubject = subjectService.createSubject(subjectDto);
        log.info("Create subject: {}", subjectDto);
        return subjectAssembler.toModel(createdSubject);
    }

    @Override
    public SubjectModel updateSubject(int id, SubjectDto subjectDto) {
        SubjectDto subjectDtoAfter = subjectService.updateSubject(id, subjectDto);
        log.info("Update subject: {}", subjectDtoAfter);
        return subjectAssembler.toModel(subjectDtoAfter);
    }


    @Override
    public ResponseEntity<Void> deleteSubject(int id) {
        log.info("Delete subject: {}", subjectService.getSubject(id));
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
