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
        Status status) {
}
