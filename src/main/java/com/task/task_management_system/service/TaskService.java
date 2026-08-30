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

        Task task = Task.builder()
                .title(req.getTitle().trim())
                .description(req.getDescription().trim())
                .status(TaskStatus.TODO)
                .build();

        Task savedTask = taskRepo.save(task);

        return CreateTaskResponse.builder()
                .id(savedTask.getId())
                .title(savedTask.getTitle())
                .description(savedTask.getDescription())
                .status(savedTask.getStatus().name())
                .createdAt(savedTask.getCreatedAt())
                .updatedAt(savedTask.getUpdatedAt())
                .build();
    }


}
