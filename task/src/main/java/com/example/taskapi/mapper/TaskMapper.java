package com.example.taskapi.mapper;

import com.example.taskapi.dto.TaskCreatRequest;
import com.example.taskapi.dto.TaskResponse;
import com.example.taskapi.dto.TaskUpdateRequest;
import com.example.taskapi.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity toEntity(TaskCreatRequest taskCreatRequest);
    TaskResponse toResponse(TaskEntity taskEntity);
    TaskEntity toEntity(TaskUpdateRequest taskUpdateRequest);
}