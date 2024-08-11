package com.example.Team.Sync.App.service;

import com.example.Team.Sync.App.dao.UserDAO;
import com.example.Team.Sync.App.model.User;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User createUser(String userName, String email, String phone, String password, User.Role role, Long departmentId) {
        User user = new User(null, userName, email, phone, password, role, departmentId);
        return userDAO.save(user);
    }

    public User getUserById(Long userId) {
        return userDAO.getUserDataBase().get(userId);
    }

    public User getUserByUserName(String userName) {
        return userDAO.findUserById(userName);
    }

    public Map<Long, User> getAllUsers() {
        return userDAO.getUserDataBase();
    }

    public User.Role getUserRoleById(Long userId) {
        User user = getUserById(userId);
        return user != null ? user.getRole() : null;
    }
}
