package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.controller.assembler.UserAssembler;
import com.epam.task3.testingsystem.controller.model.UserModel;
import com.epam.task3.testingsystem.dto.UserDto;
import com.epam.task3.testingsystem.service.UserService;
import com.epam.task3.testingsystem.swaggerApi.UserApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(int id) {
        UserDto userDto = userService.getUser(id);
        log.info("Get user: {}", userDto);
        return userAssembler.toModel(userDto);
    }

    @Override
    public CollectionModel<UserModel> getUserList() {
        log.info("Get user list");
        List<UserModel> list = userService.getUserList().stream()
                .map(userAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(list, linkTo(methodOn(UserController.class).getUserList()).withSelfRel());
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("Create user: {}", userDto);
        UserDto userDto1 = userService.createUser(userDto);
        return userAssembler.toModel(userDto1);
    }
    @Override
    public UserModel updateUser(int id, UserDto userDto) {
        UserDto userDtoAfter = userService.updateUser(id, userDto);
        log.info("Update user: {}", userDtoAfter);
        return userAssembler.toModel(userDtoAfter);
    }


    @Override
    public ResponseEntity<Void> deleteUser(int id) {
        log.info("Delete user: {}", userService.getUser(id));
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
