package com.example.craftworkschallenge.rest;

import com.example.craftworkschallenge.dto.TaskInputDTO;
import com.example.craftworkschallenge.dto.TaskDetailDTO;
import com.example.craftworkschallenge.exceptions.NotFoundException;
import com.example.craftworkschallenge.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

/**
 * Task Endpoint, which takes in HTTP Requests directed at /tasks
 */
@RestController
@RequestMapping(value = "/tasks")
public class TaskEndpoint {

    TaskService taskService;
    @Autowired
    public TaskEndpoint(TaskService taskService){
        this.taskService = taskService;
    }


    /**
     * POST Mapping function meant to receive request to add a new Task to the Database.
     * @param dto the TaskCreateDTO to be added as a Task.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewTask(@RequestBody @Valid TaskInputDTO dto){
        taskService.createNewTask(dto);
    }

    /**
     * GET Mapping function meant to receive requests to fetch all Tasks currently in the database.
     * @return A list of all TaskDetailDTOs currently in the database.
     */
    @GetMapping()
    public List<TaskDetailDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * GET Mapping function meant to receive requests to fetch a particular task from the database, based on its ID.
     * @return The task with the specified ID.
     * @throws ResponseStatusException to return a "NOT_FOUND" HTTP Error code, in case an ID is not present in the database.
     */
    @GetMapping(value = "/{id}")
    public TaskDetailDTO getTaskByID(@PathVariable UUID id){
        try{
            return taskService.getTaskByID(id);
        } catch(NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


    /**
     * PUT Mapping which updates a particular task, located by its ID.
     * @return The updated Task.
     */
    @PutMapping(value = "/{id}")
    public TaskDetailDTO updateTaskByID(@PathVariable UUID id, @RequestBody TaskInputDTO taskDTO){
        try {
        return taskService.updateTaskByID(id, taskDTO);

        } catch(NotFoundException e)    {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    /**
     * DELETE Mapping which deleted a particular task, located by its ID.
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskByID(@PathVariable UUID id){
        taskService.deleteTaskByID(id);
    }
}
