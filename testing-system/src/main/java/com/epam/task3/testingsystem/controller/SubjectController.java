package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.dto.SubjectDto;
import com.epam.task3.testingsystem.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/subjectController")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public SubjectDto getSubject(@PathVariable int id) {
        SubjectDto subjectDto = subjectService.getSubject(id);
        log.info("Get subject: {}", subjectDto);
        return subjectDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SubjectDto createSubject(@RequestBody SubjectDto subjectDto) {
        log.info("Create subject: {}", subjectDto);
        return subjectService.createSubject(subjectDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public SubjectDto updateSubject(@PathVariable int id, @RequestBody SubjectDto subjectDto) {
        SubjectDto subjectDtoAfter = subjectService.updateSubject(id, subjectDto);
        log.info("Update subject: {}", subjectDtoAfter);
        return subjectDtoAfter;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubject(@PathVariable int id) {
        log.info("Delete subject: {}", subjectService.getSubject(id));
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
