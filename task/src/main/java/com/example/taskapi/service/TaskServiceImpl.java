package com.example.taskapi.service;

import com.example.taskapi.dto.TaskCreatRequest;
import com.example.taskapi.dto.TaskResponse;
import com.example.taskapi.dto.TaskUpdateRequest;
import com.example.taskapi.entity.TaskEntity;
import com.example.taskapi.mapper.TaskMapper;
import com.example.taskapi.repository.TaskRepository;
import com.example.taskapi.validation.TaskValidation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskValidation taskValidation ;
    private final TaskMapper taskMapper;


    public TaskServiceImpl(TaskRepository taskRepository, TaskValidation taskValidation, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskValidation = taskValidation;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponse createTask(TaskCreatRequest input) {
        taskValidation.validate(input);
        TaskEntity taskEntity = taskMapper.toEntity(input);
        TaskEntity saved = taskRepository.save(taskEntity);
        return taskMapper.toResponse(saved);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        List<TaskEntity> tasks = taskRepository.findAll();
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (TaskEntity task : tasks) {
            taskResponses.add(taskMapper.toResponse(task));
        }
        return taskResponses;
    }

    @Override
    public TaskResponse updateTask(Long id, TaskUpdateRequest input) {
        taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("task is not found"));
        TaskEntity updatedEntity = taskMapper.toEntity(input);
        updatedEntity.setId(id);
        taskRepository.save(updatedEntity);
        return taskMapper.toResponse(updatedEntity);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("task is not found"));
        taskRepository.deleteById(id);
    }
}