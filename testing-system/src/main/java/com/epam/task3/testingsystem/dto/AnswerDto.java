package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class AnswerDto {

    private int id;
    @NotNull
    private String answerEn;
    @NotNull
    private String answerUa;
    @NotNull
    private boolean correct;
    @NotNull
    private int questionId;


}
