package com.taskify.milestone;


public class Task{
    
    public Task(
        int id,
        String title,
        String desc,
        boolean status)
    {
        super();
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.status = status;
    }

    private int id;
    private String title;
    private String desc;
    private boolean status;

    @Override
    public String toString(){
        return "Task [id ="+id+", Title="+title+", Description="+desc+", Status="+status+"]";
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }

    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status =status;
    }
}



