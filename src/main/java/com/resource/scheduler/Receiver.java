package com.resource.scheduler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by sprathipati on 09-11-2014.
 * receives the messages and sends to the gateway
 */
public class Receiver {

    private final static Logger log = Logger.getLogger(Receiver.class.getName());

    protected Resource resource;
    protected Gateway gateway;
    protected ResourceConfiguration config;

    protected LinkedList<Message> messageQueue = new LinkedList();
    public HashMap<String, Integer> messageMap = new HashMap();

    public Receiver() {
    }

    public Receiver(Resource res) {
        this.resource = res;
    }

    // Receives the next message
    public synchronized void receive(Message message) throws Exception {

        if (messageMap.size() == 0) {
            Iterator<Message> queue = messageQueue.iterator();
            while (queue.hasNext()) {
                Message m = (Message) queue.next();
                sendToGateway(resource, message);
                queue.remove();
            }
        }

        if (resource.isResourceAvailable(Application.resourcesList)) {
            Iterator<Message> queue = messageQueue.iterator();
            while (queue.hasNext()) {
                Message m = (Message) queue.next();
                         for (Map.Entry<String, Integer> entry : messageMap.entrySet()) {
                             if (entry.getKey().equalsIgnoreCase(resource.getResourceName()))
                                 if (messageMap.get(m.getGroupId()) == entry.getValue()) {
                                    sendToGateway(resource, message);
                                    queue.remove();
                                 }
                             }
                          }
                     }
        else {
            enqueueMessage(message, messageQueue);
           }
    }

    // send the message to gateway
    public void sendToGateway(Resource resource, Message message) {

        messageMap.put(resource.getResourceName(),message.getGroupId()) ;
        gateway.send(message);
    }

    // enqueue the message if resource is not idle
    public void enqueueMessage(Message message,LinkedList messageQueue ) {
        synchronized (messageQueue) {
            messageQueue.addLast(message);
            log.info("messageQueue() - messages queued: " + messageQueue.size());
        }
    }
}
