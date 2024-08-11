package com.example.Team.Sync.App.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.Team.Sync.App.dao.ProjectSchedulerDAO;
import com.example.Team.Sync.App.dao.ResourceAllocationDAO;
import com.example.Team.Sync.App.factory.TaskFactory;
import com.example.Team.Sync.App.model.Resource;
import com.example.Team.Sync.App.model.Task;
import com.example.Team.Sync.App.model.User;

@Service
public class ResourceAllocationService {
    private final ResourceAllocationDAO resourceDAO;
    private final AccessControlManagementService accessControlManagementService;

    public ResourceAllocationService(ResourceAllocationDAO resourceDAO,
            AccessControlManagementService accessControlManagementService) {
        this.resourceDAO = resourceDAO;
        this.accessControlManagementService = accessControlManagementService;
    }

    public Resource createResource(User user, Long userId, Boolean availableStatus, String skills,
            String shiftWorkingIn, Long taskId, Long subtaskId) {
       
        if (accessControlManagementService.canCreateResource(user)) { 
            Resource resource = new Resource();
            resource.setUser_id(userId);
            resource.setAvailable_status(availableStatus);
            resource.setSkills(skills);
            resource.setShift_working_in(shiftWorkingIn);
            resource.setTask_id(taskId);
            resource.setSubtask_id(subtaskId);
            return resourceDAO.addResource(resource);
        } else {
            throw new SecurityException("Access denied: User does not have permission to create resource.");
        }
    }

    public boolean deleteResource(User user, Long resourceId) {
        if(accessControlManagementService.canDeleteResource(user)){
            return resourceDAO.removeResource(resourceId);
        } else {
            throw new SecurityException("Access denied: User does not have permission to delete resource.");
        }
    }
}
