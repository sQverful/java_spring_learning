package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.SubjectAssembler;
import com.epam.task3.testingsystem.controller.model.SubjectModel;
import com.epam.task3.testingsystem.dto.SubjectDto;
import com.epam.task3.testingsystem.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectAssembler subjectAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public SubjectModel getSubject(@PathVariable int id) {
        SubjectDto subjectDto = subjectService.getSubject(id);
        log.info("Get subject: {}", subjectDto);
        return subjectAssembler.toModel(subjectDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SubjectModel createSubject(@Valid @RequestBody SubjectDto subjectDto) {
        SubjectDto createdSubject = subjectService.createSubject(subjectDto);
        log.info("Create subject: {}", subjectDto);
        return subjectAssembler.toModel(createdSubject);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public SubjectModel updateSubject(@PathVariable int id, @RequestBody SubjectDto subjectDto) {
        SubjectDto subjectDtoAfter = subjectService.updateSubject(id, subjectDto);
        log.info("Update subject: {}", subjectDtoAfter);
        return subjectAssembler.toModel(subjectDtoAfter);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubject(@PathVariable int id) {
        log.info("Delete subject: {}", subjectService.getSubject(id));
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
