package com.resource.scheduler;

/**
 * Created by sprathipati on 06-11-2014.
 */
public interface Gateway {

    void send(Message m);

    void completed();
}
