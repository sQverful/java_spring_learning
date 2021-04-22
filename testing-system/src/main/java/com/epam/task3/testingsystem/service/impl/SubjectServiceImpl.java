package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.SubjectDto;
import com.epam.task3.testingsystem.exception.EntityNotFoundException;
import com.epam.task3.testingsystem.model.Subject;
import com.epam.task3.testingsystem.repository.SubjectRepository;
import com.epam.task3.testingsystem.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private static final String DEFAULT_ERROR_MESSAGE = "Subject not found in DB!";
    private final SubjectRepository subjectRepository;

    @Override
    public List<SubjectDto> getSubjectList() {
        log.info("getting subject list from database");
        List<Subject> subjectList = subjectRepository.findAll();
        return subjectList.stream()
                .map(this::mapSubjectToSubjectDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDto getSubject(int id) {
        log.info("getting subject from database {}", id);
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
        return mapSubjectToSubjectDto(subject);
    }

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        log.info("creating subject in database {}", subjectDto);
        Subject subject = mapSubjectDtoToSubject(subjectDto);
        subjectRepository.save(subject);
        return mapSubjectToSubjectDto(subject);
    }

    @Override
    public SubjectDto updateSubject(int id, SubjectDto subjectDto) {
        log.info("updating subject in database {} with id {}", subjectDto, id);
        Subject subjectFromDB = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
        subjectRepository.delete(subjectFromDB);
        Subject subject = subjectRepository.save(mapSubjectDtoToSubject(subjectDto));
        return mapSubjectToSubjectDto(subject);
    }

    @Override
    public void deleteSubject(int id) {
        log.info("deleting subject in database by ID {}", id);
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DEFAULT_ERROR_MESSAGE));
        subjectRepository.delete(subject);
    }

    private SubjectDto mapSubjectToSubjectDto(Subject subject) {
        SubjectDto subjectDto = SubjectDto.builder().build();
        BeanUtils.copyProperties(subject, subjectDto);
        return subjectDto;
    }

    private Subject mapSubjectDtoToSubject(SubjectDto subjectDto) {
        Subject subject = Subject.builder().build();
        BeanUtils.copyProperties(subjectDto, subject);
        return subject;
    }
}
