package com.taskify.milestone;


import org.springframework.stereotype.Repository;

@Repository
public class TaskDAO{
    private static Tasks list = new Tasks();


    static{

        list.getTaskList().add(new Task(
            1,
            "Clean",
            "need to clean the code",
            true));
        list.getTaskList().add(new Task(
            2,
            "Test",
            "need to test the code",
            false));
        list.getTaskList().add(new Task(
            3,
            "Approve",
            "need check and aprove the code",
            false));
    }

    public Tasks getAllTasks(){
        return list;
    }

    public void addTask(Task task){
        list.getTaskList().add(task);
    }
}
