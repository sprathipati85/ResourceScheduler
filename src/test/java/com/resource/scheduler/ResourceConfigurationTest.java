package com.resource.scheduler;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sprathipati on 07-11-2014.
 */

public class ResourceConfigurationTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @InjectMocks
    private Resource resource1 = new Resource();

    @InjectMocks
    private Resource resource2= new Resource();

    private ResourceConfiguration config = new ResourceConfiguration();

    List<Resource> resources = new ArrayList();

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        resource1.setResourceName("resource1");
        resource1.setResourceStatus("IDLE");
    }

    @Test
    public void testAddResource() throws Exception {
        assertEquals(0, resources.size());

        config.addResource(resources, resource1);
        assertEquals(1, resources.size());
    }

    public void testRemoveResource() {

         assertEquals(2,resources.size());
        //When
        config.removeResource(resources, resource1);

        //Then
        assertEquals(1, resources.size());

        config.removeResource(resources, resource2);
        assertEquals(0,resources.size());
    }
}
