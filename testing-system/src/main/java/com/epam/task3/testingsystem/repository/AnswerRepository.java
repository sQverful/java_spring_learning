package com.epam.task3.testingsystem.repository;


import com.epam.task3.testingsystem.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
