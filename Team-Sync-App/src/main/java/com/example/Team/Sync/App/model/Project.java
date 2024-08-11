package com.example.Team.Sync.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
   private Long id;
   private String project_name;
   private String project_description;
   private Timestamp project_creation_date;
   private String project_status;
   private Long project_created_by;
}
