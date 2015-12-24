package com.artronics.senator.network;

import com.artronics.senator.packet.ControllerPacket;

public interface SdwnNetworkService
{
    void addNetPacket(ControllerPacket packet);
}
