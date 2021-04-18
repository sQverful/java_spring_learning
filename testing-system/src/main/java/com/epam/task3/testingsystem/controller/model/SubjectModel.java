package com.epam.task3.testingsystem.controller.model;

import com.epam.task3.testingsystem.dto.SubjectDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class SubjectModel extends RepresentationModel<SubjectModel> {

    @JsonUnwrapped
    private SubjectDto subjectDto;
}
