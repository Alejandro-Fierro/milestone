package com.taskify.milestone;

import java.util.ArrayList;
import java.util.List;

public class Tasks{
    private List<Task> tasksList;

    public List<Task> getTaskList(){
        
        //we check if its empty in case to not bring anything
        if(tasksList == null){
            tasksList = new ArrayList<>();
        }
        return tasksList;
    }

    public void setTaskList(List<Task> tasksList){
        this.tasksList=tasksList;
    }
}
