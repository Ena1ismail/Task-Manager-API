package com.example.taskapi.service;

import com.example.taskapi.dto.TaskCreatRequest;
import com.example.taskapi.dto.TaskResponse;
import com.example.taskapi.dto.TaskUpdateRequest;

import java.util.List;

public interface TaskService {
    TaskResponse createTask(TaskCreatRequest input);
    List<TaskResponse> getAllTasks();
    TaskResponse updateTask(Long id, TaskUpdateRequest input);
    void deleteTask(Long id);
}