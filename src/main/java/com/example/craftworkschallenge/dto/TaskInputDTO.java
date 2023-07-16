package com.example.craftworkschallenge.dto;

import com.example.craftworkschallenge.enums.Priority;
import com.example.craftworkschallenge.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

/**
 * DTO for Task Creation. Does not include an ID as the ID is created in the Database.
 * @param createdAt DateTime of the time of creation.
 * @param updatedAt DateTime of when the task was last updated
 * @param dueDate DateTime of when the Task is due
 * @param resolvedAt DateTime of when the task was marked as "resolved"
 * @param title Title of the Task
 * @param description Description of the Task
 * @param priority Priority of the Task, from very low to very high.
 * @param status Current status (Pending/Resolved)
 */

public record TaskInputDTO(
        @NotNull(message="A timestamp for task creation must be provided!")
        LocalDateTime createdAt,

        LocalDateTime updatedAt,
        @NotNull(message="A due date must be provided!")
        LocalDateTime dueDate,
        LocalDateTime resolvedAt,
        @NotNull(message="A title must be provided!")
        @NotBlank(message="The title must not be blank!")
        @Size(max = 250, message="Task description must not be longer than 1000 characters.")
        String title,
        @Size(max = 1000, message="Task description must not be longer than 1000 characters.")
        String description,
        @NotNull(message="A priority must be provided!")
        Priority priority,
        @NotNull(message="A status must be provided!")
        Status status
) {
}
