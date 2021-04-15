package com.epam.task3.testingsystem.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Answer {

    private int id;
    private String answerEN;
    private String answerUA;
    private boolean correct;
    private int questionId;
}
