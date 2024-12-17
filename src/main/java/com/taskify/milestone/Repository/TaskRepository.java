package com.taskify.milestone.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taskify.milestone.Status;
import com.taskify.milestone.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
    
    public List<Task> findAllByStatus(Status status);

    //We use this to switch the status of the task, with the request
    @Modifying
    @Query(value = "UPDATE TASK SET COMPLETED=true WHERE ID=:id",nativeQuery = true)
    public void markAsFinished(@Param("id") Long id);
}
