package com.resource.scheduler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sprathipati on 07-11-2014.
 */
public class Resource {

    // Resource states
    public final static String PROCESSING = "PROCESSING";
    public final static String IDLE = "IDLE";

    protected  String resourceName;
    protected  String resourceStatus;

    protected ResourceConfiguration config;
    protected LinkedList<Resource> idleResources = new LinkedList();

    public Resource(){

    }

    public Resource(String name){
        this.resourceName = name;
    }

    public void setResourceName( String name )
    {
        this.resourceName = name;
    }

    public String getResourceName()
    {
        return resourceName;
    }

    public String getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(String resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public boolean isResourceAvailable(List<Resource> resources) {
        int count = resources.size();
        if (count == 0)
            return false;

        for (int i = 0; i < count; i++) {
            if (!(resources.get(i).getResourceStatus().equalsIgnoreCase("IDLE"))) {
                idleResources.add(resources.get(i));
            }
        }
        return true;
    }

}
