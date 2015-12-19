package com.artronics.satrapi.services.impl;

import com.artronics.satrapi.entities.DeviceConnection;
import com.artronics.satrapi.repositories.DeviceConnectionRepo;
import com.artronics.satrapi.services.DeviceConnectionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceConnectionServiceImpl implements DeviceConnectionService
{
    private final static Logger log = Logger.getLogger(DeviceConnectionServiceImpl.class);

    @Autowired
    DeviceConnectionRepo connectionRepo;

    @Override
    public DeviceConnection save(DeviceConnection connection)
    {
        return connectionRepo.save(connection);
    }

    @Override
    public DeviceConnection findByController(Long controllerId, Long id)
    {
        return connectionRepo.findByController(controllerId,id);
    }
}
