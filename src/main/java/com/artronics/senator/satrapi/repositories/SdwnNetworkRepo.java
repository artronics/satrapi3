package com.artronics.senator.satrapi.repositories;

import com.artronics.senator.satrapi.entities.SdwnNetwork;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SdwnNetworkRepo extends PagingAndSortingRepository<SdwnNetwork,Long>,
                                         SdwnNetworkCustomRepo
{
}
