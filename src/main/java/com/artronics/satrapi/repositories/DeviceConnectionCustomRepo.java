package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.DeviceConnection;

public interface DeviceConnectionCustomRepo
{
    DeviceConnection findByPath(Long networkId, Long controllerId, Long id);
}
