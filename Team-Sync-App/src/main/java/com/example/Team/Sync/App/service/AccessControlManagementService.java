package com.example.Team.Sync.App.service;

import com.example.Team.Sync.App.model.User;
import com.example.Team.Sync.App.model.User.Role;

import java.util.EnumSet;

import org.springframework.stereotype.Service;
@Service
public class AccessControlManagementService {

    private static final EnumSet<Role> TASK_CREATION_ROLES = EnumSet.of(Role.SCRUM_MASTER, Role.DEVELOPER);
    private static final EnumSet<Role> TASK_DELETION_ROLES = EnumSet.of(Role.SCRUM_MASTER);
    private static final EnumSet<Role> PROJECT_CREATION_ROLES = EnumSet.of(Role.SCRUM_MASTER, Role.MANAGER);
    private static final EnumSet<Role> PROJECT_DELETION_ROLES = EnumSet.of(Role.SCRUM_MASTER, Role.MANAGER);
    private static final EnumSet<Role> PROJECT_VIEW_ROLES = EnumSet.of(Role.SCRUM_MASTER, Role.MANAGER);
    private static final EnumSet<Role> MILESTONE_CREATE_ROLES = EnumSet.of(Role.MANAGER);
    private static final EnumSet<Role> MILESTONE_DELETE_ROLES = EnumSet.of(Role.MANAGER);
    private static final EnumSet<Role> RESOURCE_CREATE_ROLES= EnumSet.of(Role.MANAGER);
    private static final EnumSet<Role> RESOURCE_DELETE_ROLES= EnumSet.of(Role.MANAGER);

    public boolean canCreateTask(User user) {
        return user.hasPermission("TASK_CREATION_ROLES");
    }

    public boolean canDeleteTask(User user) {
        return user.hasPermission("TASK_DELETION_ROLES");
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

    public boolean canCreateMilestone(User user) {
        return MILESTONE_CREATE_ROLES.contains(user.getRole());
    }

    public boolean canDeleteMilestone(User user) {
        return MILESTONE_DELETE_ROLES.contains(user.getRole());
    }

    public boolean canCreateResource(User user){
        return RESOURCE_CREATE_ROLES.contains((user.getRole()));
    }

    public boolean canDeleteResource(User user){
        return RESOURCE_DELETE_ROLES.contains(user.getRole());
    }

}
