package org.vladstasyshyn.exceptionhandling;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class UserControllerExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<UserControllerExceptionResponse> handleUserNotFoundException(UserNotFoundException exception, HttpServletRequest request) {

        var response = new UserControllerExceptionResponse(HttpStatus.NOT_FOUND.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<UserControllerExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        var response = new UserControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<UserControllerExceptionResponse> handleIllegalArgumentException(IllegalArgumentException exception, HttpServletRequest request) {

        var response = new UserControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<UserControllerExceptionResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception, HttpServletRequest request) {

        var response = new UserControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<UserControllerExceptionResponse> handleGeneralException(Exception exception, HttpServletRequest request) {

        var response = new UserControllerExceptionResponse(HttpStatus.FORBIDDEN.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }


}



