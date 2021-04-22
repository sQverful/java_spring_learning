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
    private String questionEn;
    @NotNull
    @Size(min = 2, max = 244)
    private String questionUa;
    @NotNull
    private int testId;
}
