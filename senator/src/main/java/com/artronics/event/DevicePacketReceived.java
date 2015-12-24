package com.artronics.event;

import com.artronics.packet.DevicePacket;

public class DevicePacketReceived extends BaseEvent<DevicePacket>
{
    public DevicePacketReceived(Object source, DevicePacket message)
    {
        super(source, message);
    }
}
