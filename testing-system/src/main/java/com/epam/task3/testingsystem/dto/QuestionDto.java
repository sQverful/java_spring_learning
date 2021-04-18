package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class QuestionDto {
    private int id;
    @NotNull
    @Size(min = 2, max = 244)
    private String questionEN;
    @NotNull
    @Size(min = 2, max = 244)
    private String questionUA;
    @NotNull
    private int testId;
}
