package com.taskify.milestone;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController{
    @Autowired
    private TaskDAO taskDAO;

    //GET request to bring all tasks
    @GetMapping(
        path="/",
        produces = "application/json")

    public Tasks getTasks(){
        return taskDAO.getAllTasks();
    }

    //POST to add a task
    @PostMapping(
        path="/",
        consumes = "application/json",
        produces = "application/json")

    public ResponseEntity<Object> addTask(@Valid @RequestBody Task task){
        //To know the id of the task
        Integer id = taskDAO.getAllTasks().getTaskList().size()+1;
        task.setId(id);

        taskDAO.addTask(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}