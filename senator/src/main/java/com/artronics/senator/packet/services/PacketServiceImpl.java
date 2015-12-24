package com.artronics.senator.packet.services;

import com.artronics.senator.controller.device.buffer.BufferCollector;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacketServiceImpl implements PacketService
{
    private final static Logger log = Logger.getLogger(PacketServiceImpl.class);

    @Autowired
    BufferCollector bufferCollector;

    @Override
    public void addBuffer(List<Integer> buffer)
    {
        log.debug("New buffer added.");

    }
}
