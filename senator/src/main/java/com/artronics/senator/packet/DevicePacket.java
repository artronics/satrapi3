package com.artronics.senator.packet;

import java.util.List;

public class DevicePacket implements Packet
{
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
}
