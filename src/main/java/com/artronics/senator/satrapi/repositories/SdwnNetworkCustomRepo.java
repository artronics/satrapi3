package com.artronics.senator.satrapi.repositories;

import com.artronics.senator.satrapi.entities.SdwnController;
import com.artronics.senator.satrapi.entities.SdwnNetwork;

public interface SdwnNetworkCustomRepo
{
    SdwnNetwork findByIp(String ip);

    SdwnController addSdwnController(Long netId,SdwnController controller);
}
