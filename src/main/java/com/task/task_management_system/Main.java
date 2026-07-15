package com.task.task_management_system;

import com.task.task_management_system.entity.Task;
import com.task.task_management_system.entity.TaskStatus;

public class Main {


    public static void main(String[] args) {

        Task task = new Task();

        if (task.getStatus() == TaskStatus.TODO) {
            System.out.println("Yes");
        }
    }
}
