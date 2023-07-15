package com.example.craftworkschallenge.mapper;

import com.example.craftworkschallenge.dto.TaskCreateDTO;
import com.example.craftworkschallenge.dto.TaskDetailDTO;
import com.example.craftworkschallenge.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task taskCreateDTOtoEntity(TaskCreateDTO task){
        return new Task(task.createdAt(), task.updatedAt(), task.dueDate(), task.resolvedAt(), task.title(), task.description(), task.priority(), task.status());
    }
    public TaskDetailDTO taskEntityToDetailDTO(Task task){
        return new TaskDetailDTO(task.getId(), task.getCreatedAt(), task.getUpdatedAt(), task.getDueDate(), task.getResolvedAt(), task.getTitle(), task.getDescription(), task.getPriority(), task.getStatus());
    }

    public Task taskDetailDTOtoEntity(TaskDetailDTO task){
        return new Task(task.createdAt(), task.updatedAt(), task.dueDate(), task.resolvedAt(), task.title(), task.description(), task.priority(), task.status());
    }
}
