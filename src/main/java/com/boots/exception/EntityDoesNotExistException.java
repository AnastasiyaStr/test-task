package com.boots.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityDoesNotExistException extends RuntimeException {
    public EntityDoesNotExistException() {
        super();
    }

    public EntityDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityDoesNotExistException(String message) {
        super(message);
    }

    public EntityDoesNotExistException(Throwable cause) {
        super(cause);
    }
}