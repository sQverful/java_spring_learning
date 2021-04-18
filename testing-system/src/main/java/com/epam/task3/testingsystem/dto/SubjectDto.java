package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class SubjectDto {
    private int id;
    private String nameEN;
    private String nameUA;
    private String descriptionEN;
    private String descriptionUA;
    private int adminId;
    private Timestamp createdOn;

}

