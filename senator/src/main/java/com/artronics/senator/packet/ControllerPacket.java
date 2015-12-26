package com.artronics.senator.packet;

import java.util.List;

public class ControllerPacket implements Packet
{
    private Long srcDeviceId;
    private Long srcControllerId;
    private Direction dir;

    private int len;
    private int netId;

    private int srcShortAdd;
    private int dstShortAdd;

    private Type type;

    private int nextHop;

    private ControllerPacket()
    {
    }

    public static ControllerPacket create(DevicePacket devicePacket){
        List<Integer> content = devicePacket.getContent();
        ControllerPacket packet = new ControllerPacket();

        packet.dir = Direction.RX;

        packet.len = SdwnPacketHelper.getSize(content);
        packet.netId = SdwnPacketHelper.getNetId(content);

        packet.srcShortAdd = SdwnPacketHelper.getSourceAddress(content);
        packet.dstShortAdd = SdwnPacketHelper.getDestinationAddress(content);

        packet.type = SdwnPacketHelper.getType(content);

        packet.nextHop = SdwnPacketHelper.getNextHopAddress(content);

        return packet;
    }

    @Override
    public String toLogger()
    {
        return toString();
    }

    public void setSrcControllerId(Long srcControllerId)
    {
        this.srcControllerId = srcControllerId;
    }
}
