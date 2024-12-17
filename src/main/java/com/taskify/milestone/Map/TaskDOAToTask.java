package com.taskify.milestone.Map;

import org.springframework.stereotype.Component;

import com.taskify.milestone.Status;
import com.taskify.milestone.Task;
import com.taskify.milestone.Servicio.TaskDOA;

@Component
public class TaskDOAToTask implements IMapeo<TaskDOA, Task>{

    //We map the information of each task to call in case of a findall
    @Override
    public Task map(TaskDOA in){
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDesc(in.getDesc());
        task.setStatus(Status.COMPLETED);
        return task;
    }
}
