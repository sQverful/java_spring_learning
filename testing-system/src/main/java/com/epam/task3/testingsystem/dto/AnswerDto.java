package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {
    private int id;
    private String answerEN;
    private String answerUA;
    private boolean correct;
    private int questionId;
}
