package com.artronics.senator.network;

import com.artronics.senator.packet.ControllerPacket;
import com.artronics.senator.packet.NetworkPacket;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class SdwnNetworkServiceImpl implements SdwnNetworkService
{
    private final static Logger log = Logger.getLogger(SdwnNetworkServiceImpl.class);

    @Override
    public void addCtrlPacket(ControllerPacket packet)
    {
        NetworkPacket netPacket = (NetworkPacket) packet;


    }
}
