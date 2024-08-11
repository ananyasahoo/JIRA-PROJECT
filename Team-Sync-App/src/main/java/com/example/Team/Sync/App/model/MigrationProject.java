package com.example.Team.Sync.App.model;

import java.sql.Timestamp;

public class MigrationProject extends Project {
    
    private String migrationSpecific;

    public MigrationProject(Long id, String project_name, String project_description, Timestamp project_creation_date,
            String project_status, Long project_created_by, String migrationSpecific) {
        super(id, project_name, project_description, project_creation_date,
                project_status, project_created_by);
        this.migrationSpecific = migrationSpecific;
    }
    
    public String getMigrationSpecific() {
        return migrationSpecific;
    }

    public void setMigrationSpecific(String migrationSpecific) {
        this.migrationSpecific = migrationSpecific;
    }
}
