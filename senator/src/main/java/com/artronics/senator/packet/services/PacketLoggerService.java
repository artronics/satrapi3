package com.artronics.senator.packet.services;

import com.artronics.senator.packet.Packet;

public interface PacketLoggerService
{
    <P extends Packet> void  log(P packet);
}
