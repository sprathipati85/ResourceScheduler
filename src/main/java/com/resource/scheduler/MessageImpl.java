package com.resource.scheduler;

/**
 * Created by sprathipati on 06-11-2014.
 * class that encapsulates a message
 */

public class MessageImpl implements Message {

    protected String text = "";

    protected int groupId ;

    protected String resourceName = "";
    protected Resource resource;

    public MessageImpl()
    {
    }

    public MessageImpl(String text)
    {
        this.text = new String(text);
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setText(String text) throws Exception
    {
        this.text = new String(text);
    }

    public String getText() { return text;  }

    //Gets the resource object for this message.
    public Resource getResource() throws Exception   {  return resource;  }

      //Sets the Resource object for this message.
    public void setResource(Resource resource) throws Exception { this.resource = resource; }
 }
