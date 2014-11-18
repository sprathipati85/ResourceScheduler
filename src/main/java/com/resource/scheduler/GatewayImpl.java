package com.resource.scheduler;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sprathipati on 06-11-2014.
 */
public class GatewayImpl implements Gateway {

    @Autowired
    private Resource resource;

    public void send(Message m){
        if(isMessageProcessed(m)) {
            completed();
        }
     }

    public void completed(){
        System.out.println("Completed processing message");
    }

    public boolean isMessageProcessed(Message m){
        return true;
    }
}
