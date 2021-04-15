package com.epam.task3.testingsystem.service;

import com.epam.task3.testingsystem.dto.SubjectDto;

public interface SubjectService {
    SubjectDto getSubject(int id);

    SubjectDto createSubject(SubjectDto subjectDto);

    SubjectDto updateSubject(int id, SubjectDto subjectDto);

    void deleteSubject(int id);
}
