package com.example.Team.Sync.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
   private Long id;
   private Long task_id ;
   private Long  user_id ;
   private String  file_name ;
   private String file_path ;
   private Template uploading_time ;
}
