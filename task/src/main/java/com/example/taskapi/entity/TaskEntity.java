package com.example.taskapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "task")
@Data
public class TaskEntity extends BaseEntity {
    private String title;
    private String description;
    private boolean completed;
    private LocalDate dueDate;
}