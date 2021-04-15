package com.epam.task3.testingsystem.repository;

import com.epam.task3.testingsystem.model.User;

public interface UserRepository {
    User getUser(int id);

    User createUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);
}
