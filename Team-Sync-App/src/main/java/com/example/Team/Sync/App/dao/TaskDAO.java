package com.example.Team.Sync.App.dao;

import com.example.Team.Sync.App.model.Task;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TaskDAO {
    private final Map<Long , Task> taskDataBase = new HashMap<>();
    private Long idCounter = 1L;

    public Task save(Task task){
        task.setId(idCounter++);
        taskDataBase.put(task.getId(), task);
        return  task;
    }

    public Task findTaskById(Long taskId){
        for(Task task : taskDataBase.values()){
            if(task.getId().equals(taskId)){
                return task;
            }
        }
        return null;
    }

    public Map<Long , Task> getAllTask(){
        return taskDataBase;
    }

    public Task updateTask(Task task){
        for(Task singleTask : taskDataBase.values()) {
            if (singleTask.getId().equals(task.getId())) {
                taskDataBase.put(task.getId(), task);
                return task;
            }
        }
        return null;
    }

    public Boolean deleteTask(Long taskId){
        for(Task task : taskDataBase.values()){
            if(task.getId().equals(taskId)){
                taskDataBase.remove(taskId);
                return true;
            }
        }
        return false;
    }
}
