package com.epam.task3.testingsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Timestamp;

@Data
@Builder
public class TestResult {
    private int id;
    private int result;
    private int userId;
    private int testId;
    private Timestamp createdOn;
}
