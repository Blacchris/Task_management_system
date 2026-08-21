package com.task.task_management_system.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {
    private String title;
    private String description;
    private String status;
}
