package com.artronics.senator.packet;

public class SdwnPacket implements Packet
{
    private int netId;

    private DevicePacket devicePacket;

    public SdwnPacket(DevicePacket packet)
    {
        this.devicePacket = packet;
    }

    public int getNetId()
    {
        return netId;
    }

    public void setNetId(int netId)
    {
        this.netId = netId;
    }

    @Override
    public String toLogger()
    {
        return toString();
    }
}
