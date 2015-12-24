package com.artronics.senator.packet.convertor;

import com.artronics.senator.packet.DevicePacket;

import java.util.List;

public interface PacketConvertor
{
     DevicePacket convert(List<Integer> packet);
}
