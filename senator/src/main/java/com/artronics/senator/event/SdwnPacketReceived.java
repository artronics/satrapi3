package com.artronics.senator.event;

import com.artronics.senator.packet.SdwnPacket;

public class SdwnPacketReceived extends BaseEvent<SdwnPacket>
{
    public SdwnPacketReceived(Object source, SdwnPacket message)
    {
        super(source, message);
    }
}
