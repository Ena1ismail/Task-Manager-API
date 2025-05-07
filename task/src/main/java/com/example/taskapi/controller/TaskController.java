package com.example.taskapi.controller;

import com.example.taskapi.dto.TaskCreatRequest;
import com.example.taskapi.dto.TaskResponse;
import com.example.taskapi.dto.TaskUpdateRequest;
import com.example.taskapi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse createTask(@RequestBody TaskCreatRequest taskCreatRequest) {
      return taskService.createTask(taskCreatRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse updateTask(@PathVariable Long id, @RequestBody TaskUpdateRequest input) {
        return taskService.updateTask(id, input);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
