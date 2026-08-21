package com.task.task_management_system.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTaskResponse {

    private Long id;
    private String title;
    private String description;
    private String status;

}
