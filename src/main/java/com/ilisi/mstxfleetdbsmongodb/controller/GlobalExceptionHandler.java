package com.ilisi.mstxfleetdbsmongodb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        // Log the exception or return a custom response
//        ex.printStackTrace();
        log.error("Resource not found", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
    }
}