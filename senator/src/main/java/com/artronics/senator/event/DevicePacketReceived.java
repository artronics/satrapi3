package com.artronics.senator.event;

import com.artronics.senator.packet.DevicePacket;

public class DevicePacketReceived extends BaseEvent<DevicePacket>
{
    public DevicePacketReceived(Object source, DevicePacket message)
    {
        super(source, message);
    }
}
