package com.epam.task3.testingsystem.controller.assembler;

import com.epam.task3.testingsystem.controller.model.UserModel;
import com.epam.task3.testingsystem.dto.UserDto;
import com.epam.task3.testingsystem.swaggerApi.UserApi;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public UserAssembler() {
        super(UserAssembler.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link getUserLink = linkTo(methodOn(UserApi.class).getUser(entity.getId()))
                .withRel("getUser");
        Link deleteUser = linkTo(methodOn(UserApi.class).deleteUser(entity.getId()))
                .withRel("deleteUser");
        Link updateUser = linkTo(methodOn(UserApi.class).updateUser(entity.getId(), entity))
                .withRel("updateUser");

        UserDto userDto = UserDto.builder().build();

        UserModel.of(userDto);

        userModel.add(getUserLink, deleteUser, updateUser);

        return userModel;
    }
}
