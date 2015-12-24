package com.artronics.senator.packet;

import java.util.List;

public class DevicePacket extends PacketDecorator implements Packet
{
    private List<Integer> content;

    public DevicePacket()
    {
    }

    public DevicePacket(List<Integer> content)
    {
        this.content = content;
    }

    @Override
    public List<Integer> getContent()
    {
        return null;
    }

    public void setContent(List<Integer> content)
    {
        this.content = content;
    }
}
