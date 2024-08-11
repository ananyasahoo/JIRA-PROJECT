package com.example.Team.Sync.App;

import com.example.Team.Sync.App.dao.TaskDAO;
import com.example.Team.Sync.App.model.Task;
import com.example.Team.Sync.App.model.User;
import com.example.Team.Sync.App.service.AccessControlManagementService;
import com.example.Team.Sync.App.service.TaskService;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamSyncAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamSyncAppApplication.class, args);

		
		TaskDAO taskDAO = new TaskDAO();
		User user = new User();
		AccessControlManagementService accessControlManagementService = new AccessControlManagementService();
		TaskService taskService = new TaskService(taskDAO, accessControlManagementService);

		// Create tasks
		Task featureTask = taskService.createTask(user ,"feature", 1L, "Implement feature X", "Details about feature X", 101L, new Date());
		Task bugTask = taskService.createTask(user, "bug", 1L, "Fix bug Y", "Details about bug Y", 102L, new Date());

		// Retrieve and update tasks
		Task task = taskService.getTaskById(featureTask.getId());
		System.out.println("Task: " + task.getTask_name());
		taskService.updateTask(task.getId(), "Implement feature X - updated", "Updated details", "IN_PROGRESS", new Date());

		// Delete task
		boolean deleted = taskService.deleteTask(user,bugTask.getId());
		System.out.println("Task deleted: " + deleted);
	}

}
