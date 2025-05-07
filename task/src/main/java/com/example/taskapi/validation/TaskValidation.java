package com.example.taskapi.validation;

import com.example.taskapi.dto.TaskCreatRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskValidation {

    public void validate(TaskCreatRequest taskCreatRequest) {
        validateTitle(taskCreatRequest);
        validateDueDate(taskCreatRequest);
    }

    private void validateTitle(TaskCreatRequest taskCreatRequest) {
        if (taskCreatRequest.getTitle() == null || taskCreatRequest.getTitle().trim().isEmpty()) {
            throw new RuntimeException("Title must not be empty.");
        }
    }

    private void validateDueDate(TaskCreatRequest taskCreatRequest) {
        if (taskCreatRequest.getDueDate() != null && taskCreatRequest.getDueDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Due date cannot be in the past.");
        }
    }
}