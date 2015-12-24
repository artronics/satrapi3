package com.artronics.senator.satrapi.repositories;

import com.artronics.senator.satrapi.entities.DeviceConnection;

public interface DeviceConnectionCustomRepo
{
    DeviceConnection findByPath(Long networkId, Long controllerId, Long id);
}
