package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Builder
public class TestDto {
    private int id;
    @NotNull
    @Size(min = 2, max = 244)
    private String nameEN;
    @NotNull
    @Size(min = 2, max = 244)
    private String nameUA;
    @NotNull
    @Size(min = 2, max = 3000)
    private String descriptionEN;
    @NotNull
    @Size(min = 2, max = 3000)
    private String descriptionUA;
    @NotNull
    private int subjectId;
    private boolean blocked;
    @NotNull
    @Max(100)
    private int complexity;
    private int requestsQuantity;
    private int timer;
    private Timestamp createdOn;
}
