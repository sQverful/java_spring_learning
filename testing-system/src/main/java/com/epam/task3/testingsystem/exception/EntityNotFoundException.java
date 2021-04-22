package com.epam.task3.testingsystem.exception;

/**
 * This custom exception used for other entities
 */
public class EntityNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Entity not found in DB!";

    public EntityNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

}
