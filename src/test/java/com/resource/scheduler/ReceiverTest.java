package com.resource.scheduler;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by sprathipati on 11-11-2014.
 */
public class ReceiverTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Mock
    private Resource resource;

    @Mock
    private Receiver receiver;

    @Mock
    private ResourceConfiguration config;

    protected List<Resource> resources = new ArrayList();
    protected LinkedList<Message> messageQueue = new LinkedList();
    public HashMap<String, Integer> messageMap = new HashMap();

    @Before
    public void setup() throws Exception {
        Message message = new MessageImpl();
        MockitoAnnotations.initMocks(this);
        message.setGroupId(1);
        message.setText("This is message 1 of group 1");
        messageQueue.add(message);

        resource.setResourceName("Resource1");
        resource.setResourceStatus("IDLE");
        resources.add(resource);
    }

    @Test()
    public void testReceive() throws Exception {

        assertEquals(1,messageQueue.size());

        assertEquals(1,((Message) messageQueue.getFirst()).getGroupId());
        assertEquals("This is message 1 of group 1",((Message) messageQueue.getFirst()).getText());

         //When
        Message processQueue = (Message) messageQueue.getFirst();
        receiver.receive(processQueue);

        assertEquals(1,messageQueue.size());
        //Then
    }

    public void testEnqueue() throws Exception {
        Message message1 = new MessageImpl();
        message1.setGroupId(2);
        message1.setText("This is message 2 of group 2");
        receiver.enqueueMessage(message1, messageQueue);

       verify(messageQueue).add(message1);

       messageQueue.size();
       verify(messageQueue.size());
       assertEquals(2,messageQueue.size());

       message1 = (Message) messageQueue.getLast();
       assertEquals(2, message1.getGroupId());
    }

}
