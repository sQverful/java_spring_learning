package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {
    private int id;
    private String questionEN;
    private String questionUA;
    private int testId;
}
