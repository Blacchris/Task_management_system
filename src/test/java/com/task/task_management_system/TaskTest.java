package com.task.task_management_system;

import com.task.task_management_system.dto.CreateTaskRequest;
import com.task.task_management_system.dto.CreateTaskResponse;
import com.task.task_management_system.entity.Task;
import com.task.task_management_system.entity.TaskStatus;
import com.task.task_management_system.repository.TaskRepository;
import com.task.task_management_system.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskTest {

    @Mock
    private TaskRepository taskRepo;

    @InjectMocks
    private TaskService taskService;

    @Test
    void createTask() {

        String title = "Data Structures and Algorithm";
        String description = "LinkedList";

        CreateTaskRequest req = new CreateTaskRequest();
        req.setTitle(title);
        req.setDescription(description);

        Task savedTask = Task.builder()
                .id(1L)
                .title(title)
                .description(description)
                .status(TaskStatus.TODO)
                .build();

        when(taskRepo.save(any(Task.class)))
                .thenReturn(savedTask);

        CreateTaskResponse res = taskService.createTask(req);

        assertThat(res.getTitle()).isEqualTo(title);
        assertThat(res.getDescription()).isEqualTo(description);
    }
}
