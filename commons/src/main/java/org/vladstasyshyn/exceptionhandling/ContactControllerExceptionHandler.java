package org.vladstasyshyn.exceptionhandling;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ContactControllerExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ContactControllerExceptionResponse> handleContactNotFoundException(ContactNotFoundException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.NOT_FOUND.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ContactControllerExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ContactControllerExceptionResponse> handleIllegalArgumentException(IllegalArgumentException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ContactControllerExceptionResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ResponseEntity<ContactControllerExceptionResponse> handleAccessDeniedException(AccessDeniedException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.FORBIDDEN.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<ContactControllerExceptionResponse> handleGeneralException(Exception exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.FORBIDDEN.value(), request.getRequestURI(), exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }


}
