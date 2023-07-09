package com.example.craftworkschallenge.mapper;

import com.example.craftworkschallenge.dto.TaskDTO;
import com.example.craftworkschallenge.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDTO taskEntityToDTO(Task task){
        return new TaskDTO(task.getId(), task.getCreatedAt(), task.getUpdatedAt(), task.getDueDate(), task.getResolvedAt(), task.getTitle(), task.getDescription(), task.getPriority(), task.getStatus());
    }

    public Task taskDTOtoEntity(TaskDTO task){
        return new Task(task.id(),task.createdAt(), task.updatedAt(), task.dueDate(), task.resolvedAt(), task.title(), task.description(), task.priority(), task.status());
    }
}
