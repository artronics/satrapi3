package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.PacketModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PacketRepo extends PagingAndSortingRepository<PacketModel,Long>
{
}
