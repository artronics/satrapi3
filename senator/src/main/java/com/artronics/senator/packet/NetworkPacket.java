package com.artronics.senator.packet;

import java.io.Serializable;

public class NetworkPacket extends ControllerPacket implements Serializable
{
    private Long id;
    private Long srcNetId;

    private NetworkPacket()
    {
    }

    @Override
    public String toLogger()
    {
        return null;
    }
}
