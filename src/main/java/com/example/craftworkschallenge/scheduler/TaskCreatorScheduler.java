package com.example.craftworkschallenge.scheduler;

import com.example.craftworkschallenge.entity.Task;
import com.example.craftworkschallenge.enums.Priority;
import com.example.craftworkschallenge.enums.Status;
import com.example.craftworkschallenge.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Scheduler which creates a new Task and pushes it into the repository every 10 seconds.
 */

@ControllerAdvice
public class TaskCreatorScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup()
            .lookupClass());

    private final TaskRepository taskRepository;

    private int count = 0;

    @Autowired
    public TaskCreatorScheduler(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    /**
     * Adds a task roughly every 10 seconds (10000ms).
     * The task is set as Created at the current time and is due 3 days from now.
     * All other values are static.
     */
    @Scheduled(fixedDelay = 10000)
    public void addTask(){
        Task task = new Task();
        task.setStatus(Status.PENDING);
        task.setTitle("This is a test no." + count);
        task.setDescription("Check me out.");
        task.setResolvedAt(null);
        task.setCreatedAt(LocalDateTime.now());
        task.setDueDate(LocalDateTime.now().plusDays(3));
        task.setPriority(Priority.VERY_HIGH);
        task.setUpdatedAt(null);
        LOGGER.info("SCHEDULER: " + String.format("Adding new task No. %s",count));
        count++;
        taskRepository.save(task);

    }
}
