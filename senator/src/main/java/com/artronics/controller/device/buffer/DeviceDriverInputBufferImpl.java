package com.artronics.controller.device.buffer;

import com.artronics.event.DeviceInputBufferIsReady;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeviceDriverInputBufferImpl implements DeviceDriverInputBuffer
{
    private final static Logger log = Logger.getLogger(DeviceDriverInputBufferImpl.class);

    @Autowired
    protected BufferCollector bufferCollector;

    @Override
    public void sendBuffer(List<Integer> buffer){
        List<List<Integer>> buffers = bufferCollector.generateLists(buffer);
        if (buffers.isEmpty()){
            return;
        }
        for (List<Integer> buff:buffers){
            fireDeviceBufferIsReady(buff);
        }
    }

    @EventListener
    public DeviceInputBufferIsReady fireDeviceBufferIsReady(List<Integer> buffer){
        return new DeviceInputBufferIsReady(this);
    }
}
