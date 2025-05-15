package com.example.TODOAPP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class Task_CONTROLLER {

    private final Task_SERVICE service;

    public Task_CONTROLLER(Task_SERVICE service) {
        this.service = service;
    }

    @GetMapping

    public String getAllTasks(Model model) {
        List<Task> tasks = service.Get_task();

        if (tasks.isEmpty()) {
            System.out.println("No tasks found in database!");
        } else
        {
            System.out.println("Tasks retrieved from database: ");




        }
        model.addAttribute("tasks", tasks);      // Add tasks to the model
        return "tasks";                         // Return the template name (tasks.html)
    }

    @PostMapping// Ensure you use a specific URL like "/tasks" for clarity
    public String create_Tasks(@RequestParam String title)
    {
        service.creatTask(title);
             // Add tasks to the model
        System.out.println("I am IN post");

        return "redirect:/ ";
    }
    @GetMapping("{id}/delete")
    public  String Delete_task(@PathVariable Long id)
    {
        service.delete_Task(id);
        System.out.println("delete");

        return "redirect:/ ";

    }
    @GetMapping("{id}/toggle")
    public  String Mark_task(@PathVariable Long id)
    {
        service.Marks_Task(id);

        return "redirect:/ ";

    }

}
