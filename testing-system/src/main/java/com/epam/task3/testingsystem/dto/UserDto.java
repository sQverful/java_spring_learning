package com.epam.task3.testingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private int id;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String repeatPassword;
    private boolean blocked;
    private int roleId;
}
