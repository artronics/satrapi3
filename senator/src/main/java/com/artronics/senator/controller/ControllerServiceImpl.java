package com.artronics.senator.controller;

import com.artronics.senator.network.SdwnNetworkService;
import com.artronics.senator.packet.ControllerPacket;
import com.artronics.senator.packet.DevicePacket;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@DependsOn("controllerProperties")
public class ControllerServiceImpl implements ControllerService
{
    private final static Logger log = Logger.getLogger(ControllerServiceImpl.class);

    private Long controllerId;

    @Autowired
    SdwnNetworkService networkService;

    private ControllerProperties controllerProperties;

    @PostConstruct
    public void initBean(){
        controllerId = controllerProperties.getControllerId();
        log.debug("Initializing Controller with id: "+controllerId );
    }

    @Override
    public void addDevicePacket(DevicePacket packet)
    {
        ControllerPacket controllerPacket = ControllerPacket.create(packet);
        controllerPacket.setSrcControllerId(controllerId);
        networkService.addCtrlPacket(controllerPacket);
    }

    @Autowired
    @Required
    public void setControllerProperties(
            ControllerProperties controllerProperties)
    {
        this.controllerProperties = controllerProperties;
    }
}
