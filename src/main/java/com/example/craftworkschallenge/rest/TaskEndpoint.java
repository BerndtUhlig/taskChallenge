package com.example.craftworkschallenge.rest;

import com.example.craftworkschallenge.dto.TaskCreateDTO;
import com.example.craftworkschallenge.dto.TaskDetailDTO;
import com.example.craftworkschallenge.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/tasks")
public class TaskEndpoint {

    TaskService taskService;
    @Autowired
    public TaskEndpoint(TaskService taskService){
        this.taskService = taskService;
    }


    @PostMapping
    public void createNewTask(@RequestBody @Valid TaskCreateDTO dto){
        taskService.createNewTask(dto);
    }

    @GetMapping()
    public List<TaskDetailDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/{id}")
    public TaskDetailDTO getTaskByID(@PathVariable UUID id){
        return taskService.getTaskByID(id);
    }


    @PutMapping(value = "/{id}")
    public TaskDetailDTO updateTaskByID(@PathVariable UUID id, @RequestBody TaskDetailDTO taskDTO){
        return taskService.updateTaskByID(id, taskDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTaskByID(@PathVariable UUID id){
        taskService.deleteTaskByID(id);
    }
}
