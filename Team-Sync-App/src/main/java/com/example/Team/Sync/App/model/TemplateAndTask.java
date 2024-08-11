package com.example.Team.Sync.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateAndTask {

   private Long id;
    private Long task_id;
    private Long project_id ;
    private Long  template_id;
}
