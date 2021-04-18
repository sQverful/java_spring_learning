package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Builder
public class TestResultDto {
    private int id;
    @NotNull
    @Max(100)
    private int result;
    @NotNull
    private int userId;
    @NotNull
    private int testId;
    private Timestamp createdOn;
}
