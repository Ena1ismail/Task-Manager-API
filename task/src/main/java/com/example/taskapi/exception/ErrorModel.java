package com.example.taskapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorModel {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
}