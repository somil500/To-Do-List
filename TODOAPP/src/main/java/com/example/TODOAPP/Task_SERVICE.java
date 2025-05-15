package com.example.TODOAPP;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_SERVICE
{
   private final Repository repository;
    public Task_SERVICE(Repository repository) {
        this.repository = repository;
    }





    public List<Task> Get_task()
    {
        //System.out.println(repository.findAll());

        return repository.findAll();
    }

    public void creatTask(String title)
    {
        Task task=new Task();

        task.setTitle(title);
        task.setCompleted(false);
        repository.save(task);

    }

    public void delete_Task(Long id)
    {
        repository.deleteById(id);
    }


    public void Marks_Task(Long id)
    {
      Task  task=repository.findById(id).orElseThrow(()
              -> new IllegalArgumentException("invalid arguments"));

      task.setCompleted(!task.isCompleted());

      repository.save(task);



    }
}
