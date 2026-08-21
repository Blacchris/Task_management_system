package com.task.task_management_system.controller;

import com.task.task_management_system.dto.CreateTaskRequest;
import com.task.task_management_system.dto.CreateTaskResponse;
import com.task.task_management_system.dto.UpdateTaskRequest;
import com.task.task_management_system.dto.UpdateTaskResponse;
import com.task.task_management_system.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(path = "/create")
    public ResponseEntity<CreateTaskResponse> createTask(
            @RequestBody CreateTaskRequest req
            ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.createTask(req));
    }
}
