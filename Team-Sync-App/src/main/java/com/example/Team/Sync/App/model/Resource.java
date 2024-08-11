package com.example.Team.Sync.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    private Long   id ;
    private  Long user_id;
    private Boolean available_status;
    private  String skills ;
    private  String shift_working_in;
    private  Long task_id;
    private Long subtask_id ;
}
