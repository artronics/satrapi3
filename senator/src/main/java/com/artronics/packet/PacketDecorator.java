package com.artronics.packet;

import java.io.Serializable;
import java.util.List;

//@Embeddable

public class PacketDecorator implements Packet,Serializable
{
    protected String sourceIp;

    protected Packet packet;

    public PacketDecorator(Packet packet)
    {
        this.packet = packet;
    }

    PacketDecorator()
    {
    }

    @Override
    public List<Integer> getContent()
    {
        return packet.getContent();
    }

    public String getSourceIp()
    {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp)
    {
        this.sourceIp = sourceIp;
    }
}
