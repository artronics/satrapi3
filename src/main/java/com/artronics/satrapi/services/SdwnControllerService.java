package com.artronics.satrapi.services;

import com.artronics.satrapi.entities.SdwnController;

public interface SdwnControllerService
{
    SdwnController save(SdwnController controller);

    SdwnController findOne(Long id);

    SdwnController findByNetwork(Long networkId, Long id);
}
