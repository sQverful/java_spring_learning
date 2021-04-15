package com.epam.task3.testingsystem.service;

import com.epam.task3.testingsystem.dto.UserDto;

public interface UserService {
    UserDto getUser(int id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(int id, UserDto userDto);

    void deleteUser(int id);
}
