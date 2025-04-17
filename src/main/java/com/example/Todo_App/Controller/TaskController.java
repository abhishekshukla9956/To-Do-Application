package com.example.Todo_App.Controller;

import org.springframework.ui.Model;
import com.example.Todo_App.Entity.Task;
import com.example.Todo_App.Services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService, TaskService taskService1, TaskService taskService2){

        this.taskService = taskService;
    }

    @GetMapping
    public String getTask(Model model){
        List<Task> tasks= taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(@RequestParam String title){
      taskService.createTask(title);
        return "redirect:/tasks";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable long id){
      taskService.deleteTask(id);
      return "redirect:/tasks";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable long id){
      taskService.toggleTask(id);
      return "redirect:/tasks";
    }



}
