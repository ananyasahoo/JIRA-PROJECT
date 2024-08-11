package com.example.Team.Sync.App.factory;

import java.sql.Timestamp;

import com.example.Team.Sync.App.model.DevelopmentProject;
import com.example.Team.Sync.App.model.MigrationProject;
import com.example.Team.Sync.App.model.Project;

public class ProjectFactory {

    public static Project createProject(String type, String projectName, String projectDescription, Long projectCreatedBy){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        return switch (type.toLowerCase()) {
            case "migration" ->
                    new MigrationProject(null, projectName, projectDescription, currentTime, "NEW", projectCreatedBy, "Specific value for feature");
            case "development" ->
                    new DevelopmentProject(null, projectName, projectDescription, currentTime, "NEW", projectCreatedBy, "Specific value for bug");
            // Add more cases as needed...
            default -> throw new IllegalArgumentException("Unknown project type: " + type);
        };
    }
}
