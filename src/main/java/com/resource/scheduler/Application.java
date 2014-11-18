package com.resource.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * Created by sprathipati on 06-11-2014.
 */

public class Application {

    private ResourceConfiguration resourceConfiguration;
    private Receiver receiver;
    protected static List<Resource> resourcesList = new ArrayList();

        public static void main(String[] args) throws Exception {
            System.out.println("Enter the Number of resources ");
            Scanner input = new Scanner(System.in);
            int noOfResources =  input.nextInt();
            Application application = new Application();

            application.process(noOfResources);
        }

        public void process(int noOfResources) throws Exception {

            for(int i=1; i<= noOfResources; i++) {
                Resource resource = new Resource();
                resource.setResourceName("resource" + i);
                resource.setResourceStatus("IDLE");

                resourceConfiguration.addResource(resourcesList, resource);
                System.out.println("resource size "+resourcesList.size());
            }

        //call receive method
       //   receiver.receive(message);
        }
}
