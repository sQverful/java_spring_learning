package com.epam.task3.testingsystem.exception;

public class UserNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "User not found!";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
