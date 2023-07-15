package com.example.craftworkschallenge.service.impl;

import com.example.craftworkschallenge.dto.TaskCreateDTO;
import com.example.craftworkschallenge.dto.TaskDetailDTO;
import com.example.craftworkschallenge.entity.Task;
import com.example.craftworkschallenge.exceptions.NotFoundException;
import com.example.craftworkschallenge.mapper.TaskMapper;
import com.example.craftworkschallenge.repository.TaskRepository;
import com.example.craftworkschallenge.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * Implementation of Task Service Interface.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper){
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }


    @Override
    public void createNewTask(TaskCreateDTO task) {
        taskRepository.save(taskMapper.taskCreateDTOtoEntity(task));
    }

    @Override
    public List<TaskDetailDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(taskMapper::taskEntityToDetailDTO).collect(Collectors.toList());
    }

    @Override
    public TaskDetailDTO getTaskByID(UUID id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(taskMapper::taskEntityToDetailDTO).orElse(null);
    }

    @Override
    public TaskDetailDTO updateTaskByID(UUID id, TaskDetailDTO taskDTO) {
       Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("No task with id %s found", id)));
       task.setDescription(taskDTO.description());
       task.setCreatedAt(taskDTO.createdAt());
       task.setDueDate(taskDTO.dueDate());
       task.setUpdatedAt(taskDTO.updatedAt());
       task.setPriority(taskDTO.priority());
       task.setStatus(taskDTO.status());
       task.setTitle(taskDTO.title());
       task.setResolvedAt(taskDTO.resolvedAt());
       taskRepository.save(task);
       return this.taskMapper.taskEntityToDetailDTO(task);
    }

    @Override
    public void deleteTaskByID(UUID id) {
        taskRepository.deleteById(id);
    }
}
