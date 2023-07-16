package com.example.craftworkschallenge.service;

import com.example.craftworkschallenge.dto.TaskInputDTO;
import com.example.craftworkschallenge.dto.TaskDetailDTO;

import java.util.List;
import java.util.UUID;

/**
 * Task Service Interface
 */

public interface TaskService {
    void createNewTask(TaskInputDTO task);

    List<TaskDetailDTO> getAllTasks();

    TaskDetailDTO getTaskByID(UUID id);

    TaskDetailDTO updateTaskByID(UUID id, TaskInputDTO task);

    void deleteTaskByID(UUID id);
}
