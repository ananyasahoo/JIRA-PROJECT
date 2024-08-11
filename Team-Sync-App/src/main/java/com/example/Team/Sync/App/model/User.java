package com.example.Team.Sync.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id ;
    private String  user_name ;
    private String email ;
    private String phone;
    private String password;
    private Role role;
    private Long department_id ;

    public enum Role {
        SCRUM_MASTER,
        DEVELOPER,
        NORMAL_USER,
        TESTER,
        MANAGER
    }

}
