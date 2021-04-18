package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AnswerDto {
    private int id;
    @NotNull
    private String answerEN;
    @NotNull
    private String answerUA;
    @NotNull
    private boolean correct;
    @NotNull
    private int questionId;
}
