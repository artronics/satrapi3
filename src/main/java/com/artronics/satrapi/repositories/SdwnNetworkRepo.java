package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.network.SdwnNetwork;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SdwnNetworkRepo extends PagingAndSortingRepository<SdwnNetwork,String>
{
}
