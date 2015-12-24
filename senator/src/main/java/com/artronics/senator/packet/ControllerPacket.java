package com.artronics.senator.packet;

public class ControllerPacket implements Packet
{
    Long sourceCtrlId;

    private DevicePacket devicePacket;

    public ControllerPacket(DevicePacket devicePacket)
    {
        this.devicePacket = devicePacket;
    }

    public Long getSourceCtrlId()
    {
        return sourceCtrlId;
    }

    public void setSourceCtrlId(Long sourceCtrlId)
    {
        this.sourceCtrlId = sourceCtrlId;
    }

    @Override
    public String toLogger()
    {
        return toString();
    }
}
