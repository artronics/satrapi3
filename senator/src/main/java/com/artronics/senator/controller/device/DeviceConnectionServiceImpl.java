package com.artronics.senator.controller.device;

import com.artronics.senator.controller.ControllerService;
import com.artronics.senator.controller.device.buffer.BufferCollector;
import com.artronics.senator.controller.device.connection.Connection;
import com.artronics.senator.event.DeviceInputBufferIsReady;
import com.artronics.senator.packet.DevicePacket;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DependsOn("deviceProperties")
public class DeviceConnectionServiceImpl implements DeviceConnectionService
{
    private final static Logger log = Logger.getLogger(DeviceConnectionServiceImpl.class);

    protected DeviceProperties deviceProperties;

    @Autowired
    BufferCollector bufferCollector;

    @Autowired
    ControllerService controllerService;

    Connection connection;

    @Override
    public void init()
    {

    }
    
    @EventListener
    public void deviceInputBufferIsReadyHandler(DeviceInputBufferIsReady event){
        log.debug("New Event: " +event.toString());
        collectBuffAndCallService(event.getMessage());
    }

    private void collectBuffAndCallService(List<Integer> message)
    {
        List<List<Integer>> buffers = bufferCollector.generateLists(message);
        if (buffers.isEmpty()){
            return;
        }
        log.debug("This buffer contains "+buffers.size()+" packets");
        for (List<Integer> buff:buffers){
            DevicePacket devicePacket = new DevicePacket(buff);
            devicePacket.setSrcDeviceId(deviceProperties.getId());

            controllerService.addDevicePacket(devicePacket);
        }
    }

    @Autowired
    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }

    @Autowired
    public void setDeviceProperties(
            DeviceProperties deviceProperties)
    {
        this.deviceProperties = deviceProperties;
    }
}
