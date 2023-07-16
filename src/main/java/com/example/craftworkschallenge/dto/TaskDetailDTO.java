package com.example.craftworkschallenge.dto;


import com.example.craftworkschallenge.enums.Priority;
import com.example.craftworkschallenge.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.time.LocalDateTime;
import java.util.UUID;


/**
 * DTO including ID. This TaskDTO is supposed to be returned by the backend.
 * @param id
 * @param createdAt
 * @param updatedAt
 * @param dueDate
 * @param resolvedAt
 * @param title
 * @param description
 * @param priority
 * @param status
 */
public record TaskDetailDTO(
        UUID id,
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
        Status status) {
}
