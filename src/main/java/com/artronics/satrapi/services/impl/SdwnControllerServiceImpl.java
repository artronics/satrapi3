package com.artronics.satrapi.services.impl;

import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.repositories.SdwnControllerRepo;
import com.artronics.satrapi.services.SdwnControllerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SdwnControllerServiceImpl implements SdwnControllerService
{
    private final static Logger log = Logger.getLogger(SdwnControllerServiceImpl.class);

    @Autowired
    SdwnControllerRepo controllerRepo;

    @Override
    public SdwnController save(SdwnController controller)
    {
        return controllerRepo.save(controller);
    }
}
