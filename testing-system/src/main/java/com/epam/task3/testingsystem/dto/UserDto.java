package com.epam.task3.testingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private int id;
    @NotNull
    private String login;
    private String name;
    private String surname;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;
    private boolean blocked;
    private int roleId;
}
