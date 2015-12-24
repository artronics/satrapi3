package com.artronics.senator.satrapi.services;

import com.artronics.senator.satrapi.entities.SdwnNetwork;

public interface SdwnNetworkService
{
    SdwnNetwork save(SdwnNetwork network);

    SdwnNetwork findByIp(String ip);
}
