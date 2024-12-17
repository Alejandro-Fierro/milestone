package com.taskify.milestone;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskify.milestone.Servicio.TaskDOA;
import com.taskify.milestone.Servicio.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    //Call to service to use the methods
    public TaskController(TaskService service){
        this.service = service;
    }

    //Request POST
    @PostMapping
    public Task createTask(@RequestBody TaskDOA taskDOA){
        return this.service.createTask(taskDOA);
    }

    //Request GET
    @GetMapping
    public List<Task> findAll(){
        return this.service.findAll();
    }

    //Request GET by Status
    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") Status status){
        return this.service.finAllByStatus(status);
    }

    //Request to change status
    @PatchMapping("/mark_completed/{id}")
    public ResponseEntity<Void> markAsCompleted(@PathVariable("id")Long id){
        this.service.updateTaskAsCompleted(id);
        return ResponseEntity.noContent().build();
    }


    //Request to DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}