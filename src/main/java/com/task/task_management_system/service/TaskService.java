package com.task.task_management_system.service;


import com.task.task_management_system.dto.CreateTaskRequest;
import com.task.task_management_system.dto.CreateTaskResponse;
import com.task.task_management_system.dto.UpdateTaskRequest;
import com.task.task_management_system.dto.UpdateTaskResponse;
import com.task.task_management_system.entity.Task;
import com.task.task_management_system.entity.TaskStatus;
import com.task.task_management_system.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepo;

    public CreateTaskResponse createTask(CreateTaskRequest req) {
        Task task = taskRepo.save(
                Task.builder()
                        .title(req.getTitle())
                        .description(req.getDescription())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );

        return CreateTaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus().name())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }


}
