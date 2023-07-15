package com.example.craftworkschallenge.repository;


import com.example.craftworkschallenge.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Task JPA Repository. No changes needed as all requested methods are part of the standard implementation.
 */
public interface TaskRepository extends JpaRepository<Task, UUID> {


}
