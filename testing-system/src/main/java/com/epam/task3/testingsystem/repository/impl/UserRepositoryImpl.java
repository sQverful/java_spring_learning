package com.epam.task3.testingsystem.repository.impl;

import com.epam.task3.testingsystem.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements com.epam.task3.testingsystem.repository.UserRepository {

    private List<User> list = new ArrayList<>();

    @Override
    public User getUser(int id) {
        return list.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public User createUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        boolean isDeleted = list.removeIf(user1 -> user1.getId() == id);
        if (isDeleted) {
            list.add(user);
        } else {
            throw new RuntimeException("UserService does not exists!!!");
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        list.removeIf(user -> user.getId() == id);
    }
}
