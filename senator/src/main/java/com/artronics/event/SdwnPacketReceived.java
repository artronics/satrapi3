package com.artronics.event;

import com.artronics.packet.SdwnPacket;

public class SdwnPacketReceived extends BaseEvent<SdwnPacket>
{
    public SdwnPacketReceived(Object source, SdwnPacket message)
    {
        super(source, message);
    }
}
