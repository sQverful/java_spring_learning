package com.epam.task3.testingsystem.swaggerApi;

import com.epam.task3.testingsystem.controller.model.UserModel;
import com.epam.task3.testingsystem.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "User management API")
@RequestMapping("/api/v1/users")
public interface UserApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "User id"),
    })

    @ApiOperation("Get user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    UserModel getUser(@PathVariable int id);

    @ApiOperation("Get user list")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    CollectionModel<UserModel> getUserList();

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@Valid @RequestBody UserDto userDto);

    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    UserModel updateUser(@PathVariable int id, @RequestBody UserDto userDto);

    @ApiOperation("Delete user")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@PathVariable int id);
}
