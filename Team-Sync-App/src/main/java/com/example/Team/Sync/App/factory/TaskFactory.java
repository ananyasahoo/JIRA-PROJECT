package com.example.Team.Sync.App.factory;

import com.example.Team.Sync.App.model.BugTask;
import com.example.Team.Sync.App.model.FeatureTask;
import com.example.Team.Sync.App.model.Task;

import java.sql.Timestamp;
import java.util.Date;

public class TaskFactory {

    public static Task createTask(String type, Long projectId, String taskName, String taskDescription, Long taskCreatedBy, Date dueDate) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return switch (type.toLowerCase()) {
            case "feature" ->
                    new FeatureTask(null, projectId, taskName, taskDescription, currentTime, null, null, "NEW", taskCreatedBy, dueDate, "Specific value for feature");
            case "bug" ->
                    new BugTask(null, projectId, taskName, taskDescription, currentTime, null, null, "NEW", taskCreatedBy, dueDate, "Specific value for bug");
            // Add more cases as needed...
            default -> throw new IllegalArgumentException("Unknown task type: " + type);
        };
    }
}

