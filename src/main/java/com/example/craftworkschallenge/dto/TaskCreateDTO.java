package com.example.craftworkschallenge.dto;

import com.example.craftworkschallenge.enums.Priority;
import com.example.craftworkschallenge.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

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

public record TaskCreateDTO(
        @NotNull
        LocalDateTime createdAt,

        LocalDateTime updatedAt,
        @NotNull
        LocalDateTime dueDate,
        LocalDateTime resolvedAt,
        @NotNull
        @NotBlank
        @Size(max = 250, message="Task description must not be longer than 1000 characters.")
        String title,
        @Size(max = 1000, message="Task description must not be longer than 1000 characters.")
        String description,
        @NotNull
        Priority priority,
        @NotNull
        Status status
) {
}
