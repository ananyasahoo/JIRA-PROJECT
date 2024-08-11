package com.example.Team.Sync.App.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.Team.Sync.App.model.Resource;

@Repository
public class ResourceAllocationDAO {
     private final Map<Long, Resource> resourceDataBase = new HashMap<>();
    private Long idCounter = 1L;

     public Resource addResource(Resource resource) {
        resource.setId(idCounter++);
        resourceDataBase.put(resource.getId(), resource);
        return resource;
    }

      public Boolean removeResource(Long resourceid) {
        for (Resource resource : resourceDataBase.values()) {
            if (resource.getId().equals(resourceid)) {
               resourceDataBase.remove(resourceid);
                return true;
            }
        }
        return false;
    }
}
