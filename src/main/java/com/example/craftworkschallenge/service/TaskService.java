package com.example.craftworkschallenge.service;

import com.example.craftworkschallenge.dto.TaskDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    void createNewTask(TaskDTO task);

    List<TaskDTO> getAllTasks();

    TaskDTO getTaskByID(UUID id);

    TaskDTO updateTaskByID(UUID id, TaskDTO task);

    void deleteTaskByID(UUID id);
}
