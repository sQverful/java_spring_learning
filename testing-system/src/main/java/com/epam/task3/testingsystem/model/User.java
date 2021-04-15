package com.epam.task3.testingsystem.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class User {
    private int id;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Timestamp createTime;
    private boolean blocked;
    private int roleId;
}
