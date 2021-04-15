package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.UserDto;
import com.epam.task3.testingsystem.model.User;
import com.epam.task3.testingsystem.repository.UserRepository;
import com.epam.task3.testingsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(int id) {
        User user = userRepository.getUser(id);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        userRepository.updateUser(id, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }


    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .roleId(user.getRoleId())
                .blocked(user.isBlocked())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .roleId(userDto.getRoleId())
                .blocked(userDto.isBlocked())
                .password(userDto.getPassword())
                .build();
    }

}
