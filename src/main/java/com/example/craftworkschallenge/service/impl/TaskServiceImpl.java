package com.example.craftworkschallenge.service.impl;

import com.example.craftworkschallenge.dto.TaskInputDTO;
import com.example.craftworkschallenge.dto.TaskDetailDTO;
import com.example.craftworkschallenge.entity.Task;
import com.example.craftworkschallenge.exceptions.NotFoundException;
import com.example.craftworkschallenge.mapper.TaskMapper;
import com.example.craftworkschallenge.repository.TaskRepository;
import com.example.craftworkschallenge.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * Implementation of Task Service Interface.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup()
            .lookupClass());
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper){
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }


    @Override
    public void createNewTask(TaskInputDTO task) {
        LOGGER.debug("Service: Creating a new Task");
        taskRepository.save(taskMapper.taskCreateDTOtoEntity(task));
    }

    @Override
    public List<TaskDetailDTO> getAllTasks() {
        LOGGER.debug("Service: Fetching all tasks");
        return taskRepository.findAll().stream().map(taskMapper::taskEntityToDetailDTO).toList();
    }

    @Override
    public TaskDetailDTO getTaskByID(UUID id) {
        LOGGER.debug("Service: Fetching task by id");
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("No task with id %s found", id)));
        return taskMapper.taskEntityToDetailDTO(task);
    }

    @Override
    public TaskDetailDTO updateTaskByID(UUID id, TaskInputDTO taskDTO) {
        LOGGER.debug("Service: Updating task by id");
       Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("No task with id %s found", id)));
       task.setDescription(taskDTO.description());
       task.setCreatedAt(taskDTO.createdAt());
       task.setDueDate(taskDTO.dueDate());
       task.setUpdatedAt(LocalDateTime.now());
       task.setPriority(taskDTO.priority());
       task.setStatus(taskDTO.status());
       task.setTitle(taskDTO.title());
       task.setResolvedAt(taskDTO.resolvedAt());
       taskRepository.save(task);
       return this.taskMapper.taskEntityToDetailDTO(task);
    }

    @Override
    public void deleteTaskByID(UUID id) {
        LOGGER.debug("Service: Deleting task by id");
        taskRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("No task with id %s found", id)));
        taskRepository.deleteById(id);
    }

}
