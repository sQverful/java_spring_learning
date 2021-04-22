package com.epam.task3.testingsystem.repository;

import com.epam.task3.testingsystem.dto.TestDto;
import com.epam.task3.testingsystem.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
