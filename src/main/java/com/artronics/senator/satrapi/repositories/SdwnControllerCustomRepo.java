package com.artronics.senator.satrapi.repositories;

import com.artronics.senator.satrapi.entities.SdwnController;

public interface SdwnControllerCustomRepo
{
    SdwnController findByNetwork(Long networkId, Long id);
}
