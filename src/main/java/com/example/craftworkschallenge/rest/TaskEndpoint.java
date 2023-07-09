package com.example.craftworkschallenge.rest;

import com.example.craftworkschallenge.dto.TaskDTO;
import com.example.craftworkschallenge.entity.Task;
import com.example.craftworkschallenge.service.TaskService;
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
    public void createNewTask(@RequestBody TaskDTO dto){
        taskService.createNewTask(dto);
    }

    @GetMapping()
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/{id}")
    public TaskDTO getTaskByID(@PathVariable UUID id){
        return taskService.getTaskByID(id);
    }


    @PutMapping(value = "/{id}")
    public TaskDTO updateTaskByID(@PathVariable UUID id, @RequestBody TaskDTO taskDTO){
        return taskService.updateTaskByID(id, taskDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTaskByID(@PathVariable UUID id){
        taskService.deleteTaskByID(id);
    }
}
