package com.example.Team.Sync.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Milestone {
  private Long id ;
    private String  milestone_name;
    private Timestamp milestone_date;
    private Long  project_id;
    private String status;
    private Timestamp created_at ;
    private Timestamp updated_at;
}
