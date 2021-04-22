package com.epam.task3.testingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "test_result")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int result;
    private int userId;
    private int testId;
    @CreationTimestamp
    private Timestamp createdOn;
}
