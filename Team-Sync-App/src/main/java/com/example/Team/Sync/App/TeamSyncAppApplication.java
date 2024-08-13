package com.example.Team.Sync.App;

import com.example.Team.Sync.App.dao.ProjectSchedulerDAO;
import com.example.Team.Sync.App.dao.ResourceAllocationDAO;
import com.example.Team.Sync.App.dao.TaskDAO;
import com.example.Team.Sync.App.model.Milestone;
import com.example.Team.Sync.App.model.Resource;
import com.example.Team.Sync.App.model.Task;
import com.example.Team.Sync.App.model.User;
import com.example.Team.Sync.App.service.AccessControlManagementService;
import com.example.Team.Sync.App.service.ProjectSchedulerService;
import com.example.Team.Sync.App.service.ResourceAllocationService;
import com.example.Team.Sync.App.service.TaskService;

import java.security.Permission;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamSyncAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamSyncAppApplication.class, args);

		// Initializing UserDAO, TaskDAO, and AccessControlManagementService
		TaskDAO taskDAO = new TaskDAO();
		ResourceAllocationDAO resourceDAO = new ResourceAllocationDAO();
		ProjectSchedulerDAO projectSchedulerDAO = new ProjectSchedulerDAO();
		AccessControlManagementService accessControlManagementService = new AccessControlManagementService();

		// Set permissions for the user
		Set<String> permissions = new HashSet<>();
		permissions.add("TASK_CREATION_ROLES");
		permissions.add("TASK_DELETION_ROLES");
		permissions.add("RESOURCE_CREATE_ROLES");
		permissions.add("RESOURCE_DELETE_ROLES");
		permissions.add("MILESTONE_CREATE_ROLES");
		permissions.add("MILESTONE_DELETE_ROLES");

		// Create a new user with the necessary permissions
		User user = new User(1L, "adminUser", "admin@example.com", "1234567890", "password", User.Role.MANAGER, 1L,
				permissions);
		// Create TaskService
		TaskService taskService = new TaskService(taskDAO, accessControlManagementService);
		ResourceAllocationService resourceAllocationService = new ResourceAllocationService(resourceDAO,
				accessControlManagementService);
		ProjectSchedulerService projectSchedulerService = new ProjectSchedulerService(projectSchedulerDAO,
				accessControlManagementService);

		// Create tasks using the user with the correct permissions
		Task featureTask = taskService.createTask(user, "feature", 1L, "Implement feature X", "Details about feature X",
				101L, new Date());

		Resource resource = resourceAllocationService.createResource(user, 1L, true, "Java, Spring", "Day Shift",
				featureTask.getId(), null);
		boolean isDeletedResource = resourceAllocationService.deleteResource(user, resource.getId());

		Timestamp startDate = Timestamp.valueOf(LocalDateTime.of(2024, 8, 20, 18, 0));
		Timestamp endDate = Timestamp.valueOf(LocalDateTime.of(2024, 9, 20, 18, 0));
		Timestamp actualEndDate = Timestamp.valueOf(LocalDateTime.of(2024, 7, 12, 18, 0));

		// Create a milestone
		Milestone milestone = projectSchedulerService.createMilestone(user, "Initial Project Setup", "Not Started",
				startDate, actualEndDate, endDate, null);
		Map<Long, Milestone> allMilestones = projectSchedulerService.getAllMilestone();
		System.out.println("All Milestones: " + allMilestones);
		// System.out.println("Resource Allocated: " + resource.getId());
		// System.out.println("Milestone created"+ milestone);
		//System.out.println(isDeletedResource + "deleted");
	}
}
