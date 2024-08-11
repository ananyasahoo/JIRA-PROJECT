package com.example.Team.Sync.App.model;

import java.sql.Timestamp;

public class DevelopmentProject extends Project {
    private String developmentSpecific;

    public DevelopmentProject(Long id, String project_name, String project_description, Timestamp project_creation_date,
                              String project_status, Long project_created_by, String developmentSpecific) {
        super(id, project_name, project_description, project_creation_date, project_status, project_created_by);
        this.developmentSpecific = developmentSpecific;
    }

    // Getter and setter for developmentSpecific
    public String getDevelopmentSpecific() {
        return developmentSpecific;
    }

    public void setDevelopmentSpecific(String developmentSpecific) {
        this.developmentSpecific = developmentSpecific;
    }
}
