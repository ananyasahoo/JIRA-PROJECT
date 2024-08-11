package com.example.Team.Sync.App.dao;

import com.example.Team.Sync.App.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAO {
    private final Map<Long , User> userDataBase = new HashMap<>();
    private Long idCounter = 1L;

    public User save(User user){
        user.setId(idCounter++);
        userDataBase.put(user.getId(), user);
        return  user;
    }

    public User findUserByUserName(String userName) {
        return userDataBase.values().stream()
                .filter(user -> user.getUser_name().equals(userName))
                .findFirst()
                .orElse(null);
    }
    
    public Map<Long, User> getUserDataBase() {
        return userDataBase;
    }
    
}
