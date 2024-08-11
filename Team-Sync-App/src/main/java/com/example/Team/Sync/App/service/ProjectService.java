package com.example.Team.Sync.App.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Team.Sync.App.dao.ProjectDAO;
import com.example.Team.Sync.App.factory.ProjectFactory;
import com.example.Team.Sync.App.model.Project;
import com.example.Team.Sync.App.model.User;

@Service
public class ProjectService {

    private final ProjectDAO projectDAO;
    private final AccessControlManagementService accessControlManagementService;

    public ProjectService(ProjectDAO projectDAO,AccessControlManagementService accessControlManagementService) {
        this.projectDAO = projectDAO;
        this.accessControlManagementService = accessControlManagementService;
    }

    public Project createProject(User user, String type, String projectName, String projectDescription,
            Long projectCreatedBy) {

        if (accessControlManagementService.canCreateProject(user)) {
            Project project = ProjectFactory.createProject(type, projectName, projectDescription, projectCreatedBy);
            return projectDAO.save(project);
        } else {
            throw new SecurityException("Access denied: User does not have permission to create project.");
        }
    }
    
    public Project getProjectById(Long projectId) {
        return projectDAO.findProjectById(projectId);
    }

    public Map<Long, Project> getAllProject() {
        return projectDAO.getAllProject();
    }

    public Project updateProject(User user,Long projectId, String projectName, String projectDescription) {
        if (accessControlManagementService.canCreateProject(user)) {
            Project project = projectDAO.findProjectById(projectId);
            if(project != null){
                project.setProject_name(projectName);
                project.setProject_description(projectDescription);
                return projectDAO.updateProject(project);
            }
            else {
                return null;
            }
        }else {
            throw new SecurityException("Access denied: User does not have permission to create project.");
        }
    }

    public boolean deleteProject(User user, Long projectId) {
        if(accessControlManagementService.canDeleteProject(user)){
            return projectDAO.deleteProject(projectId);
        } else {
            throw new SecurityException("Access denied: User does not have permission to delete project.");
        }
    }
}
