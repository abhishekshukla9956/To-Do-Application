package com.example.Todo_App.Repository;

import com.example.Todo_App.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepo extends JpaRepository<Task, Long> {
}
