package com.example.Team.Sync.App.dao;

import com.example.Team.Sync.App.model.Project;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProjectDAO {
    private final Map<Long , Project> projectDataBase = new HashMap<>();
    private Long idCounter = 1L;

    public Project save(Project project){
        project.setId(idCounter++);
        projectDataBase.put(project.getId(), project);
        return  project;
    }

    public Project findProjectById(Long projectId){
        for(Project project : projectDataBase.values()){
            if(project.getId().equals(projectId)){
                return project;
            }
        }
        return null;
    }

    public Map<Long , Project> getAllProject(){
       return projectDataBase;
    }

    public Project updateProject(Project project){
        for(Project singleProject : projectDataBase.values()) {
            if (singleProject.getId().equals(project.getId())) {
                projectDataBase.put(project.getId(), project);
                return project;
            }
        }
        return null;
    }

    public Boolean deleteProject(Long projectId){
        for(Project project : projectDataBase.values()){
            if(project.getId().equals(projectId)){
                projectDataBase.remove(projectId);
                return true;
            }
        }
        return false;
    }
}
