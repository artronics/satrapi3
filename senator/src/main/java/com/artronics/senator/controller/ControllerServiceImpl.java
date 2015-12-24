package com.artronics.senator.controller;

import com.artronics.senator.packet.ControllerPacket;
import com.artronics.senator.packet.DevicePacket;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@DependsOn("controllerProperties")
public class ControllerServiceImpl implements ControllerService
{
    private final static Logger log = Logger.getLogger(ControllerServiceImpl.class);

    private Long controllerId;

    private ControllerProperties controllerProperties;

    @PostConstruct
    public void initBean(){
        controllerId = controllerProperties.getControllerId();
    }

    @Override
    public void addDevicePacket(DevicePacket packet)
    {
        ControllerPacket controllerPacket = ControllerPacket.create(packet);

    }
}
