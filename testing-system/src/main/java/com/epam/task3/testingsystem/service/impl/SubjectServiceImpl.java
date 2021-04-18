package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.SubjectDto;
import com.epam.task3.testingsystem.model.Subject;
import com.epam.task3.testingsystem.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements com.epam.task3.testingsystem.service.SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public SubjectDto getSubject(int id) {
        Subject subject = subjectRepository.getSubject(id);
        return mapSubjectToSubjectDto(subject);
    }

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = mapSubjectDtoToSubject(subjectDto);
        subjectRepository.createSubject(subject);
        return mapSubjectToSubjectDto(subject);
    }

    @Override
    public SubjectDto updateSubject(int id, SubjectDto subjectDto) {
        Subject subject = subjectRepository.updateSubject(id, mapSubjectDtoToSubject(subjectDto));
        return mapSubjectToSubjectDto(subject);
    }

    @Override
    public void deleteSubject(int id) {
        subjectRepository.deleteSubject(id);
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
