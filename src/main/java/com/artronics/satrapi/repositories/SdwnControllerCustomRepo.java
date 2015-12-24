package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.SdwnController;

public interface SdwnControllerCustomRepo
{
    SdwnController findByNetwork(Long networkId, Long id);
}
