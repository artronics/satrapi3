package com.artronics.senator.packet;

public class SdwnPacket extends PacketDecorator
{
    private int netId;

    public SdwnPacket(DevicePacket packet)
    {
        super(packet);
    }

    public int getNetId()
    {
        return netId;
    }

    public void setNetId(int netId)
    {
        this.netId = netId;
    }
}
