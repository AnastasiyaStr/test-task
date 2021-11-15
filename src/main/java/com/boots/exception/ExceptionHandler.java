package com.boots.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

    private static final String ITEM_NOT_FOUND_MESSAGE = "Item not found";

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<String> processValidationError(EntityDoesNotExistException ex) {

        return new ResponseEntity<>(ITEM_NOT_FOUND_MESSAGE, HttpStatus.NOT_FOUND);
    }
}
