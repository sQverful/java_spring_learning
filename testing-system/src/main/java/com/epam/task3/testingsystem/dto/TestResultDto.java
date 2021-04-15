package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class TestResultDto {
    private int id;
    private int result;
    private int userId;
    private int testId;
    private Timestamp createdOn;
}
