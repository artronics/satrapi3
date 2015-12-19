package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.DeviceConnection;

public interface DeviceConnectionCustomRepo
{
    DeviceConnection findByController(Long controllerId, Long id);
}
