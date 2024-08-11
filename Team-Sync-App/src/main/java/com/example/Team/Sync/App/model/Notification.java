package com.example.Team.Sync.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
   private Long id ;
    private String message ;
    private Long user_id;
    private Timestamp send_at ;
}
