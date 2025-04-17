package com.example.Todo_App.Services;

import com.example.Todo_App.Entity.Task;
import com.example.Todo_App.Repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
     return taskRepo.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepo.save(task);
    }

    public void deleteTask(long id) {
        taskRepo.deleteById(id);
    }

    public void toggleTask(long id) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
          if(task!=null) {
              task.setCompleted(!task.isCompleted());
              taskRepo.save(task);
          }

    }
}
