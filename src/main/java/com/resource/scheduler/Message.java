package com.resource.scheduler;

/**
 * Created by sprathipati on 06-11-2014.
 */
public interface Message {

    public int getGroupId();

    public void setGroupId(int groupId);

    public void setText(String text) throws Exception;

    public String getText() ;

}
