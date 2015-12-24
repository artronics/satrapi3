package com.artronics.senator.packet;

import java.util.List;

public class DevicePacket implements Packet
{
    private Long srcDeviceId;

    private final List<Integer> content;

    public DevicePacket(List<Integer> content)
    {
        this.content = content;
    }

    public List<Integer> getContent()
    {
        return null;
    }

    @Override
    public String toLogger()
    {
        return toString();
    }

    public Long getSrcDeviceId()
    {
        return srcDeviceId;
    }

    public void setSrcDeviceId(Long srcDeviceId)
    {
        this.srcDeviceId = srcDeviceId;
    }
}
