package com.example.craftworkschallenge.mapper;

import com.example.craftworkschallenge.dto.TaskCreateDTO;
import com.example.craftworkschallenge.dto.TaskDetailDTO;
import com.example.craftworkschallenge.entity.Task;
import org.springframework.stereotype.Component;

/**
 * Mapper class which maps the different DTOs to an Entity and vice versa.
 */
@Component
public class TaskMapper {

    /**
     * Function to map TaskCreateDTOs to Task Entities.
     * @param task The TaskCreateDTO to be mapped to a task entity.
     * @return A Task entity based on the DTO.
     */
    public Task taskCreateDTOtoEntity(TaskCreateDTO task){
        return new Task(task.createdAt(), task.updatedAt(), task.dueDate(), task.resolvedAt(), task.title(), task.description(), task.priority(), task.status());
    }
    /**
     * Function to map Task Entities to TaskDetailDTOs.
     * @param task The Task Entity to be mapped to a task entity.
     * @return A TaskDetailDTO based on the Task entity.
     */
    public TaskDetailDTO taskEntityToDetailDTO(Task task){
        return new TaskDetailDTO(task.getId(), task.getCreatedAt(), task.getUpdatedAt(), task.getDueDate(), task.getResolvedAt(), task.getTitle(), task.getDescription(), task.getPriority(), task.getStatus());
    }

}
