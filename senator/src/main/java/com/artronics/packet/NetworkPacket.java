package com.artronics.packet;

import java.io.Serializable;

public class NetworkPacket extends ControllerPacket implements Serializable
{
    private Long id;

    private ControllerPacket controllerPacket;

    private String sourceIp;

    public NetworkPacket(DevicePacket devicePacket)
    {
        super(devicePacket);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
