package com.artronics.senator.mocks;

import com.artronics.senator.event.DeviceInputBufferIsReady;
import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MockEventHandler
{
    private final static Logger log = Logger.getLogger(MockEventHandler.class);

    @EventListener
    public void bufferInputReceived(DeviceInputBufferIsReady e){
        System.out.println("insode");
    }
}
