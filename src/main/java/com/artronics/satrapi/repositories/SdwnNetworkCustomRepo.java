package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.SdwnNetwork;

public interface SdwnNetworkCustomRepo
{
    SdwnNetwork findByIp(String ip);
}
