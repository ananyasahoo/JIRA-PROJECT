package com.example.Team.Sync.App.service;

import com.example.Team.Sync.App.model.User;
import com.example.Team.Sync.App.model.User.Role;

import java.util.EnumSet;

public class AccessControlManagementService {

    private static final EnumSet<Role> TASK_CREATION_ROLES = EnumSet.of(Role.SCRUM_MASTER, Role.DEVELOPER);
    private static final EnumSet<Role> TASK_DELETION_ROLES = EnumSet.of(Role.SCRUM_MASTER);
    private static final EnumSet<Role> PROJECT_CREATION_ROLES = EnumSet.of(Role.SCRUM_MASTER, Role.MANAGER);
    private static final EnumSet<Role> PROJECT_DELETION_ROLES = EnumSet.of(Role.SCRUM_MASTER, Role.MANAGER);
    private static final EnumSet<Role> PROJECT_VIEW_ROLES = EnumSet.of(Role.SCRUM_MASTER, Role.MANAGER);

    public boolean canCreateTask(User user) {
        return TASK_CREATION_ROLES.contains(user.getRole());
    }

    public boolean canDeleteTask(User user) {
        return TASK_DELETION_ROLES.contains(user.getRole());
    }

    public boolean canCreateProject(User user) {
        return PROJECT_CREATION_ROLES.contains(user.getRole());
    }

    public boolean canDeleteProject(User user) {
        return PROJECT_DELETION_ROLES.contains(user.getRole());
    }

    public boolean canViewAllProjects(User user) {
        return PROJECT_VIEW_ROLES.contains(user.getRole());
    }
}
