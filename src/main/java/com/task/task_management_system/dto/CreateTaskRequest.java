package com.task.task_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskRequest {

    @Size(min = 3, max = 50)
    @NotBlank(message = "Title is required")
    private String title;

    @Size(min = 5, max = 100)
    @NotBlank(message = "Description is required")
    private String description;
}
