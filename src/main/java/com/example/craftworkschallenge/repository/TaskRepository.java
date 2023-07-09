package com.example.craftworkschallenge.repository;


import com.example.craftworkschallenge.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {


}
