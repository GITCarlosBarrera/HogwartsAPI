package com.example.hogwarts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalState(IllegalStateException ex) {
        // Este método captura la "explosión" de tu test y la convierte en un 409
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
