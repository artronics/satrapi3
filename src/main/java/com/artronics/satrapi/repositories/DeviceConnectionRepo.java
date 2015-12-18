package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.DeviceConnection;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeviceConnectionRepo extends PagingAndSortingRepository<DeviceConnection,Long>
{
}
