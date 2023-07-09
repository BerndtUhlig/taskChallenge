package com.example.craftworkschallenge.dto;


import com.example.craftworkschallenge.enums.Priority;
import com.example.craftworkschallenge.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDTO(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate, LocalDateTime resolvedAt, String title, String description, Priority priority, Status status) {
}
