package com.artronics.senator.controller;

import com.artronics.senator.packet.DevicePacket;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("controllerProperties")
public class ControllerServiceImpl implements ControllerService
{
    private final static Logger log = Logger.getLogger(ControllerServiceImpl.class);

    @Override
    public void addDevicePacket(DevicePacket packet)
    {

    }
}
