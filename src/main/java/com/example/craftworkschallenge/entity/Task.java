package com.example.craftworkschallenge.entity;


import com.example.craftworkschallenge.enums.Priority;
import com.example.craftworkschallenge.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "createdAt")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "dueDate")
    @NotNull
    private LocalDateTime dueDate;

    @Column(name = "resolvedAt")
    private LocalDateTime resolvedAt;

    @Column(name = "title")
    @NotNull
    @NotBlank
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private Priority priority;


    @Column(name = "status")
    private Status status;

    public Task() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Task(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate, LocalDateTime resolvedAt, String title, String description, Priority priority, Status status) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dueDate = dueDate;
        this.resolvedAt = resolvedAt;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
