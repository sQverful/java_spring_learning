package com.epam.task3.testingsystem.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Test {
    private int id;
    private String nameEN;
    private String nameUA;
    private String descriptionEN;
    private String descriptionUA;
    private int subjectId;
    private boolean blocked;
    private int complexity;
    private int requestsQuantity;
    private int timer;
    private Timestamp createdOn;
}
