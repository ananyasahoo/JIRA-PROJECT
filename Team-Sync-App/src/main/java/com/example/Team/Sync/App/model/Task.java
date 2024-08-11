package com.example.Team.Sync.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private Long project_id;
    private String task_name;
    private String task_description;
    private Timestamp task_creation_date;
    private Timestamp task_start_date;
    private Timestamp task_end_date;
    private String task_status;
    private Long task_created_by;
    private Date due_date;
}

