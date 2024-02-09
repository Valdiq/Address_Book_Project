package org.vladstasyshyn.exceptionhandling;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.vladstasyshyn.logging.logger.ApiLogger;
import org.vladstasyshyn.logging.util.LogExceptionHandlerUtil;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ContactControllerExceptionHandler {

    private final Map<String, ApiLogger> apiLoggerMap;

    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ContactControllerExceptionResponse> handleContactNotFoundException(ContactNotFoundException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.NOT_FOUND.value(), request.getRequestURI(), exception.getClass().getName(), exception.getMessage(), LocalDateTime.now());

        LogExceptionHandlerUtil.logError(response, List.of("mongoLogger", "traceLogger"), apiLoggerMap);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ContactControllerExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getClass().getName(), exception.getMessage(), LocalDateTime.now());

        LogExceptionHandlerUtil.logError(response, List.of("mongoLogger", "traceLogger"), apiLoggerMap);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ContactControllerExceptionResponse> handleIllegalArgumentException(IllegalArgumentException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getClass().getName(), exception.getMessage(), LocalDateTime.now());

        LogExceptionHandlerUtil.logError(response, List.of("mongoLogger", "traceLogger"), apiLoggerMap);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ContactControllerExceptionResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), exception.getClass().getName(), exception.getMessage(), LocalDateTime.now());

        LogExceptionHandlerUtil.logError(response, List.of("mongoLogger", "traceLogger"), apiLoggerMap);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ResponseEntity<ContactControllerExceptionResponse> handleAccessDeniedException(AccessDeniedException exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.FORBIDDEN.value(), request.getRequestURI(), exception.getClass().getName(), exception.getMessage(), LocalDateTime.now());

        LogExceptionHandlerUtil.logError(response, List.of("mongoLogger"), apiLoggerMap);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<ContactControllerExceptionResponse> handleGeneralException(Exception exception, HttpServletRequest request) {

        var response = new ContactControllerExceptionResponse(HttpStatus.FORBIDDEN.value(), request.getRequestURI(), exception.getClass().getName(), exception.getMessage(), LocalDateTime.now());

        LogExceptionHandlerUtil.logError(response, List.of("mongoLogger"), apiLoggerMap);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
}