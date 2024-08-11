package com.example.Team.Sync.App.model;

import java.sql.Timestamp;
import java.util.Date;

public class BugTask extends Task {
    private String bugSpecificField;

    public BugTask(Long id, Long projectId, String taskName, String taskDescription, Timestamp taskCreationDate,
            Timestamp taskStartDate, Timestamp taskEndDate, String taskStatus, Long taskCreatedBy, Date dueDate,
            String bugSpecificField) {
        super(id, projectId, taskName, taskDescription, taskCreationDate, taskStartDate, taskEndDate, taskStatus,
                taskCreatedBy, dueDate);
        this.bugSpecificField = bugSpecificField;
    }
    
    public String getBugSpecificField() {
        return this.bugSpecificField;
    }
}
