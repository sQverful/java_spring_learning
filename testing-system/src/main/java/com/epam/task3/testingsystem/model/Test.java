package com.epam.task3.testingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "test")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameEn;
    private String nameUa;
    private String descriptionEn;
    private String descriptionUa;
    private int subjectId;
    private boolean blocked;
    private int complexity;
    private Integer requestsQuantity;
    private int timer;
    @CreationTimestamp
    private Timestamp createTime;
}
