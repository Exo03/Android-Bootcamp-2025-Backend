package com.example.bootcamp.exception.handler;

import com.example.bootcamp.exception.IncorrectPasswordException;
import com.example.bootcamp.exception.PersonAlreadyExistException;
import com.example.bootcamp.exception.PersonNotFoundException;
import com.example.bootcamp.exception.VolunteerCenterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(VolunteerCenterNotFoundException.class)
    public ResponseEntity<String> handleVolunteerCenterNotFoundException(VolunteerCenterNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonAlreadyExistException.class)
    public ResponseEntity<String> handlerPersonAlreadyExistException(PersonAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<String> handlerIncorrectPasswordException(IncorrectPasswordException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
