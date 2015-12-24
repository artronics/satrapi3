package com.artronics.senator.satrapi.repositories;

import com.artronics.senator.satrapi.entities.DeviceConnection;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeviceConnectionRepo extends PagingAndSortingRepository<DeviceConnection,Long>,
                                              DeviceConnectionCustomRepo
{
}
