package com.artronics.senator.packet;

public class ControllerPacket implements Packet
{
    private Long srcDeviceId;
    private Long srcControllerId;

    private int srcShortAdd;
    private int dstShortAdd;

    public static ControllerPacket create(DevicePacket devicePacket){
        return new ControllerPacket();
    }

    @Override
    public String toLogger()
    {
        return toString();
    }
}
