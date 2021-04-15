package com.epam.task3.testingsystem.repository;

import com.epam.task3.testingsystem.model.Subject;

import java.util.List;

public interface SubjectRepository {
    Subject createSubject(Subject subject);

    Subject getSubject(int id);

    Subject updateSubject(int id, Subject subject);

    void deleteSubject(int id);

    List<Subject> getList();
}
