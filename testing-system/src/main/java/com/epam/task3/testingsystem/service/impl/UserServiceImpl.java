package com.epam.task3.testingsystem.service.impl;

import com.epam.task3.testingsystem.dto.UserDto;
import com.epam.task3.testingsystem.exception.UserNotFoundException;
import com.epam.task3.testingsystem.model.User;
import com.epam.task3.testingsystem.repository.UserRepository;
import com.epam.task3.testingsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getUserList() {
        log.info("getting user list from database");
        List<User> list = userRepository.findAll();
        return list
                .stream()
                .map(user -> mapUserToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(int id) {
        log.info("getting user from database by id {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("creating user in database: {}", userDto);
        User user = mapUserDtoToUser(userDto);
        userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        log.info("updating user in database: {}", userDto);
        userDto.setId(id);
        User user = mapUserDtoToUser(userDto);
        User userFromDB = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
//        userRepository.delete(userFromDB);
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(int id) {
        log.info("deleting user in database by id {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
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
                .createTime(user.getCreateTime())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .login(userDto.getLogin())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .roleId(userDto.getRoleId())
                .blocked(userDto.isBlocked())
                .password(userDto.getPassword())
                .createTime(userDto.getCreateTime())
                .build();
    }

}
