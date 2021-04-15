package com.epam.task3.testingsystem.repository.impl;

import com.epam.task3.testingsystem.model.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectRepositoryImpl implements com.epam.task3.testingsystem.repository.SubjectRepository {

    private List<Subject> list = new ArrayList<>();

    @Override
    public Subject createSubject(Subject subject) {
        list.add(subject);
        return subject;
    }

    @Override
    public Subject getSubject(int id) {
        return list.stream()
                .filter(subject -> subject.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Subject updateSubject(int id, Subject subject) {
        boolean isDeleted = list.removeIf(s -> s.getId() == id);
        if (isDeleted) {
            list.add(subject);
        } else {
            throw new RuntimeException("Subject does not exists!");
        }
        return subject;
    }

    @Override
    public void deleteSubject(int id) {
        list.removeIf(subject -> subject.getId() == id);
    }

    @Override
    public List<Subject> getList() {
        return list;
    }
}
