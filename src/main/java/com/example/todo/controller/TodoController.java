package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins="*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Task> getAllTasks()
    {
        return todoService.findAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task)
    {
        return todoService.saveTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task)
    {
        return todoService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id)
    {
        todoService.deleteTask(id);
    }


}
