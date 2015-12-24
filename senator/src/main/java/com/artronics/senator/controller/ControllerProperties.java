package com.artronics.senator.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("controllerProperties")
public class ControllerProperties
{
    private final static Logger log = Logger.getLogger(ControllerProperties.class);
    private final static String BASE_PATH = "com.artronics.senator.controller";

    Long controllerId;

    public Long getControllerId()
    {
        return controllerId;
    }

    @Required
    @Value("${" + BASE_PATH + ".id}")
    public void setControllerId(Long controllerId)
    {
        this.controllerId = controllerId;
    }
}
