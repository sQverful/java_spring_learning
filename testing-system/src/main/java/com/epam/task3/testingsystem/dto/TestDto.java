package com.epam.task3.testingsystem.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Builder
public class TestDto {
    private int id;
    @NotNull
    @Size(min = 2, max = 244)
    private String nameEn;
    @NotNull
    @Size(min = 2, max = 244)
    private String nameUa;
    @NotNull
    @Size(min = 2, max = 3000)
    private String descriptionEn;
    @NotNull
    @Size(min = 2, max = 3000)
    private String descriptionUa;
    @NotNull
    private int subjectId;
    private boolean blocked;
    @NotNull
    @Max(100)
    private int complexity;
    private Integer requestsQuantity;
    private int timer;
    private Timestamp createTime;
}
