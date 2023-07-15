package com.example.craftworkschallenge.service;

import com.example.craftworkschallenge.dto.TaskCreateDTO;
import com.example.craftworkschallenge.dto.TaskDetailDTO;

import java.util.List;
import java.util.UUID;

/**
 * Task Service Interface
 */

public interface TaskService {
    void createNewTask(TaskCreateDTO task);

    List<TaskDetailDTO> getAllTasks();

    TaskDetailDTO getTaskByID(UUID id);

    TaskDetailDTO updateTaskByID(UUID id, TaskDetailDTO task);

    void deleteTaskByID(UUID id);
}
