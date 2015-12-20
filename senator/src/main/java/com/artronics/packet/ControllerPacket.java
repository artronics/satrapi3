package com.artronics.packet;

public class ControllerPacket //extends PacketDecorator
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
}
