package com.example.Team.Sync.App.model;

import java.sql.Timestamp;
import java.util.Date;

public class FeatureTask extends Task {
    private String featureSpecificField;

    public FeatureTask(Long id, Long projectId, String taskName, String taskDescription, Timestamp taskCreationDate,
            Timestamp taskStartDate, Timestamp taskEndDate, String taskStatus, Long taskCreatedBy, Date dueDate,
            String featureSpecificField) {
        super(id, projectId, taskName, taskDescription, taskCreationDate, taskStartDate, taskEndDate, taskStatus,
                taskCreatedBy, dueDate);
        this.featureSpecificField = featureSpecificField;
    }
    
    public String getFeatureSpecificField() {
        return this.featureSpecificField;
    }

}
