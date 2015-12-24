package com.artronics.senator.controller.device.connection;

import com.artronics.senator.controller.device.buffer.BufferCollector;
import com.artronics.senator.event.DeviceInputBufferIsReady;
import com.artronics.senator.packet.services.PacketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeviceConnectionServiceImpl implements DeviceConnectionService
{
    private final static Logger log = Logger.getLogger(DeviceConnectionServiceImpl.class);
    
    @Autowired
    BufferCollector bufferCollector;
    
    @Autowired
    PacketService packetService;

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
            packetService.addBuffer(buff);
        }
    }

    @Autowired
    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }
}
