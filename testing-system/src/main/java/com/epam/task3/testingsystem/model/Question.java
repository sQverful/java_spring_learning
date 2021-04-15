package com.epam.task3.testingsystem.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Question {
    private int id;
    private String questionEN;
    private String questionUA;
    private int testId;
}
