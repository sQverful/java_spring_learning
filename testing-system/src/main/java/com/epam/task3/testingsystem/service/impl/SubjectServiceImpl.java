package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.SubjectDto;
import com.epam.task3.testingsystem.model.Subject;
import com.epam.task3.testingsystem.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


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
        return SubjectDto.builder()
                .id(subject.getId())
                .nameEN(subject.getNameEN())
                .nameUA(subject.getNameUA())
                .descriptionEN(subject.getDescriptionEN())
                .descriptionUA(subject.getDescriptionUA())
                .adminId(subject.getAdminId())
                .createdOn(subject.getCreatedOn())
                .build();
    }

    private Subject mapSubjectDtoToSubject(SubjectDto subjectDto) {
        return Subject.builder()
                .id(subjectDto.getId())
                .nameEN(subjectDto.getNameEN())
                .nameUA(subjectDto.getNameUA())
                .descriptionEN(subjectDto.getDescriptionEN())
                .descriptionUA(subjectDto.getDescriptionUA())
                .adminId(subjectDto.getAdminId())
                .createdOn(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}
