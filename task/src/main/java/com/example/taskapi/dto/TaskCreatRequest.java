package com.example.taskapi.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TaskCreatRequest {
    private String title;
    private String description;
    private LocalDate dueDate;
}