package com.example.craftworkschallenge.entity;


import com.example.craftworkschallenge.enums.Priority;
import com.example.craftworkschallenge.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "dueDate")
    private LocalDateTime dueDate;

    @Column(name = "resolvedAt")
    private LocalDateTime resolvedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private Priority priority;


    @Column(name = "status")
    private Status status;

}
