package com.taskify.milestone.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taskify.milestone.Status;
import com.taskify.milestone.Task;
import com.taskify.milestone.Map.TaskDOAToTask;
import com.taskify.milestone.Repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskDOAToTask mapeo;

    //Call to service to use the methods
    public TaskService(TaskRepository repository, TaskDOAToTask mapeo){
        this.repository = repository;
        this.mapeo = mapeo;
    }


    //Post or create a new task
    public Task createTask(TaskDOA taskD){
        Task task = mapeo.map(taskD);
        return this.repository.save(task);
    }

    //Get all tasks
    public List<Task> findAll(){
        return this.repository.findAll();
    }

    //Find by Status
    public List<Task>finAllByStatus(Status state){
        return this.repository.findAllByStatus(state);
    }


    //Update
    @Transactional
    public void updateTaskAsCompleted(Long id){
        this.repository.markAsFinished(id);
    }


    //Delete
    public void deleteById(Long id){
        this.repository.deleteById(id);
    }
}