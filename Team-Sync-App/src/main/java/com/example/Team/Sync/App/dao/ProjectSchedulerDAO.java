package com.example.Team.Sync.App.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.example.Team.Sync.App.model.Milestone;

@Repository
public class ProjectSchedulerDAO {
    private final Map<Long, Milestone> milestoneDataBase = new HashMap<>();
    private Long idCounter = 1L;

    public Milestone addMilestone(Milestone milestone) {
        milestone.setId(idCounter++);
        milestoneDataBase.put(milestone.getId(), milestone);
        return milestone;
    }

    public Milestone getMilestoneById(Long milesId) {
        for (Milestone miles : milestoneDataBase.values()) {
            if (miles.getId().equals(milesId)) {
                return miles;
            }
        }
        return null;
    }

    public Map<Long, Milestone> getAllMilestone() {
        return milestoneDataBase;
    }

    public Boolean removeMilestone(Long milesid) {
        for (Milestone miles : milestoneDataBase.values()) {
            if (miles.getId().equals(milesid)) {
                milestoneDataBase.remove(milesid);
                return true;
            }
        }
        return false;
    }
}
