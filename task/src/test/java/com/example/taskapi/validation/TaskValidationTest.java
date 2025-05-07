package com.example.taskapi.validation;

import com.example.taskapi.dto.TaskCreatRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskValidationTest {

    private final TaskValidation taskValidation = new TaskValidation();

    @Test
    void validateTitle_ShouldThrowException_WhenTitleIsNull() {
        TaskCreatRequest request = createRequest(null, LocalDate.now().plusDays(1));
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> taskValidation.validate(request)
        );
        assertEquals("Title must not be empty.", exception.getMessage());
    }

    @Test
    void validateTitle_ShouldThrowException_WhenTitleIsEmpty() {
        TaskCreatRequest request = createRequest("", LocalDate.now().plusDays(1));
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> taskValidation.validate(request)
        );
        assertEquals("Title must not be empty.", exception.getMessage());
    }

    @Test
    void validateTitle_ShouldNotThrowException_WhenTitleIsValid() {
        TaskCreatRequest request = createRequest("Valid Title", LocalDate.now().plusDays(1));
        assertDoesNotThrow(() -> taskValidation.validate(request));
    }

    @Test
    void validateDueDate_ShouldThrowException_WhenDueDateIsPast() {
        TaskCreatRequest request = createRequest("Valid Title", LocalDate.now().minusDays(1));
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> taskValidation.validate(request)
        );
        assertEquals("Due date cannot be in the past.", exception.getMessage());
    }

    @Test
    void validateDueDate_ShouldNotThrowException_WhenDueDateIsToday() {
        TaskCreatRequest request = createRequest("Valid Title", LocalDate.now());
        assertDoesNotThrow(() -> taskValidation.validate(request));
    }

    @Test
    void validateDueDate_ShouldNotThrowException_WhenDueDateIsFuture() {
        TaskCreatRequest request = createRequest("Valid Title", LocalDate.now().plusDays(1));
        assertDoesNotThrow(() -> taskValidation.validate(request));
    }

    @Test
    void validateDueDate_ShouldNotThrowException_WhenDueDateIsNull() {
        TaskCreatRequest request = createRequest("Valid Title", null);
        assertDoesNotThrow(() -> taskValidation.validate(request));
    }

    @Test
    void validate_ShouldNotThrowException_WhenRequestIsValid() {
        TaskCreatRequest request = createRequest("Valid Title", LocalDate.now().plusDays(1));
        assertDoesNotThrow(() -> taskValidation.validate(request));
    }

    private TaskCreatRequest createRequest(String title, LocalDate dueDate) {
        TaskCreatRequest request = new TaskCreatRequest();
        request.setTitle(title);
        request.setDescription("Sample description");
        request.setDueDate(dueDate);
        return request;
    }
}