package com.example.Team.Sync.App.service;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Team.Sync.App.dao.ProjectSchedulerDAO;
import com.example.Team.Sync.App.model.Milestone;
import com.example.Team.Sync.App.model.User;

@Service
public class ProjectSchedulerService {
    private final ProjectSchedulerDAO projectSchedulerDAO;
    private final AccessControlManagementService accessControlManagementService;

    public ProjectSchedulerService(ProjectSchedulerDAO projectSchedulerDAO,
            AccessControlManagementService accessControlManagementService) {
        this.projectSchedulerDAO = projectSchedulerDAO;
        this.accessControlManagementService = accessControlManagementService;
    }

    public Milestone createMilestone(User user, String milestoneName, String status, Timestamp milestoneDate,
            Timestamp createdAt, Timestamp updatedAt, Long projectId) {

        if (accessControlManagementService.canCreateMilestone(user)) {

            Milestone milestone = new Milestone();
            milestone.setMilestone_name(milestoneName);
            milestone.setStatus(status);
            milestone.setMilestone_date(milestoneDate);
            milestone.setCreated_at(createdAt);
            milestone.setUpdated_at(updatedAt);
            milestone.setProject_id(projectId);

            return projectSchedulerDAO.addMilestone(milestone);
        } else {
            throw new SecurityException("Access denied: User does not have permission to create milestone.");
        }
    }

    public Milestone getMilestoneById(Long milestoneId) {
        return projectSchedulerDAO.getMilestoneById(milestoneId);
    }

    public Map<Long, Milestone> getAllMilestone() {
        return projectSchedulerDAO.getAllMilestone();
    }

    public boolean deleteMilestone(User user, Long milestoneId) {
        if (accessControlManagementService.canDeleteMilestone(user)) {
            return projectSchedulerDAO.removeMilestone(milestoneId);
        } else {
            throw new SecurityException("Access denied: User does not have permission to delete milestone.");
        }
    }

}
