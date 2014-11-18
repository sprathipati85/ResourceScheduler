package com.resource.scheduler;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by sprathipati on 07-11-2014.
 * class to configure, add and remove the number of resources
 */
public class ResourceConfiguration {

    protected boolean deleted = false;

    //add the number of resources
    public void addResource(List<Resource> resources, Resource res) {
        resources.add(res);
    }

    // remove the number of resources
    public void removeResource(List<Resource> resources,Resource res) {

        ListIterator<Resource> iterator = resources.listIterator();
        while (iterator.hasNext()) {
            Resource resource = (Resource) iterator.next();
             if (res.getResourceName().equalsIgnoreCase(resource.getResourceName())){
                 iterator.remove();
                return;
            }
        }
    }
}
