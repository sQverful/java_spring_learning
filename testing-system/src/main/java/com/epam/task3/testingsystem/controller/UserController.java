package com.epam.task3.testingsystem.controller;

import com.epam.task3.testingsystem.dto.UserDto;
import com.epam.task3.testingsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public UserDto getUser(@PathVariable int id) {
        UserDto userDto = userService.getUser(id);
        log.info("Get user: {}", userDto);
        return userDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("Create user: {}", userDto);
        return userService.createUser(userDto);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        UserDto userDtoAfter = userService.updateUser(id, userDto);
        log.info("Update user: {}", userDtoAfter);
        return userDtoAfter;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        log.info("Delete user: {}", userService.getUser(id));
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
