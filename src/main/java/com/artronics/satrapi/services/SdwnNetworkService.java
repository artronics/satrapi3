package com.artronics.satrapi.services;

import com.artronics.satrapi.entities.SdwnNetwork;

public interface SdwnNetworkService
{
    SdwnNetwork save(SdwnNetwork network);

    SdwnNetwork findByIp(String ip);
}
